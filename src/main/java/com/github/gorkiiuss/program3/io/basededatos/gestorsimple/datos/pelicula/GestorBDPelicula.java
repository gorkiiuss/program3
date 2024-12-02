package com.github.gorkiiuss.program3.io.basededatos.gestorsimple.datos.pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestorBDPelicula {
    private static GestorBDPelicula instance;

    private GestorBDPelicula() { }

    public static synchronized GestorBDPelicula get() {
        if (instance == null) instance = new GestorBDPelicula();
        return instance;
    }

    public Pelicula[] obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer la conexión
            String url = "jdbc:mysql://localhost:3306/cine?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "java";
            String password = "java";

            conn = DriverManager.getConnection(url, user, password);

            // Crear una declaración
            stmt = conn.createStatement();

            // Ejecutar la consulta
            String sql = "SELECT * FROM peliculas";
            rs = stmt.executeQuery(sql);

            // Procesar el ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                String protagonista = rs.getString("protagonista");
                String genero = rs.getString("genero");
                int duracionEnMinutos = rs.getInt("duracionEnMinutos");

                Pelicula pelicula = new Pelicula(id, titulo, director, protagonista, genero, duracionEnMinutos);
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return peliculas.toArray(new Pelicula[0]);
    }

    public void guardarTodasLasPeliculas(Pelicula[] peliculas) {
        String url = "jdbc:mysql://localhost:3306/cine?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "java";
        String password = "java";

        String comprobarSiPeliculaYaExiste = "SELECT 1 FROM peliculas WHERE id = ?";
        String actualizarPelicula = "UPDATE peliculas SET titulo = ?, director = ?, protagonista = ?, genero = ?, duracionEnMinutos = ? WHERE id = ?";
        String agregarNuevaPelicula = "INSERT INTO peliculas (id, titulo, director, protagonista, genero, duracionEnMinutos) VALUES (?, ?, ?, ?, ?, ?)";
        String eliminarPeliculasObsoletas = "DELETE FROM peliculas WHERE id NOT IN (%s)";

        Connection conn = null;
        PreparedStatement stmtCheck = null;
        PreparedStatement stmtUpdate = null;
        PreparedStatement stmtInsert = null;
        PreparedStatement stmtDelete = null;

        try {
            // Establecer la conexión
            conn = DriverManager.getConnection(url, user, password);
            // Deshabilitar auto-commit para manejar transacciones manualmente
            conn.setAutoCommit(false);

            // Preparar las sentencias
            stmtCheck = conn.prepareStatement(comprobarSiPeliculaYaExiste);
            stmtUpdate = conn.prepareStatement(actualizarPelicula);
            stmtInsert = conn.prepareStatement(agregarNuevaPelicula);

            // Conjunto para almacenar todos los IDs proporcionados
            Set<Integer> idsProporcionados = new HashSet<>();

            for (Pelicula pelicula : peliculas) {
                idsProporcionados.add(pelicula.getId());

                // Verificar si la película ya existe
                stmtCheck.setInt(1, pelicula.getId());
                try (ResultSet rs = stmtCheck.executeQuery()) {
                    if (rs.next()) {
                        // La película existe, proceder a actualizar
                        stmtUpdate.setString(1, pelicula.getTitulo());
                        stmtUpdate.setString(2, pelicula.getDirector());
                        stmtUpdate.setString(3, pelicula.getProtagonista());
                        stmtUpdate.setString(4, pelicula.getGenero());
                        stmtUpdate.setInt(5, pelicula.getDuracionEnMinutos());
                        stmtUpdate.setInt(6, pelicula.getId());

                        stmtUpdate.executeUpdate();
                    } else {
                        // La película no existe, proceder a insertar
                        stmtInsert.setInt(1, pelicula.getId());
                        stmtInsert.setString(2, pelicula.getTitulo());
                        stmtInsert.setString(3, pelicula.getDirector());
                        stmtInsert.setString(4, pelicula.getProtagonista());
                        stmtInsert.setString(5, pelicula.getGenero());
                        stmtInsert.setInt(6, pelicula.getDuracionEnMinutos());

                        stmtInsert.executeUpdate();
                    }
                }
            }

            // Preparar la sentencia de eliminación
            if (!idsProporcionados.isEmpty()) {
                // Construir una lista separada por comas de los IDs
                StringBuilder placeholders = new StringBuilder();
                for (int i = 0; i < idsProporcionados.size(); i++) {
                    placeholders.append("?");
                    if (i < idsProporcionados.size() - 1) {
                        placeholders.append(", ");
                    }
                }

                String sqlDelete = String.format(eliminarPeliculasObsoletas, placeholders);
                stmtDelete = conn.prepareStatement(sqlDelete);

                int index = 1;
                for (Integer id : idsProporcionados) {
                    stmtDelete.setInt(index++, id);
                }

                // Ejecutar la eliminación
                stmtDelete.executeUpdate();
            } else {
                // Si no hay IDs proporcionados, eliminar todas las películas
                String sqlDeleteAll = "DELETE FROM peliculas";
                stmtDelete = conn.prepareStatement(sqlDeleteAll);
                stmtDelete.executeUpdate();
            }

            // Confirmar la transacción
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // Intentar realizar un rollback en caso de error
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Transacción revertida debido a un error.");
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                    System.out.println("Error al realizar el rollback.");
                }
            }
        } finally {
            // Cerrar recursos en orden inverso de apertura
            try {
                if (stmtDelete != null) stmtDelete.close();
                if (stmtInsert != null) stmtInsert.close();
                if (stmtUpdate != null) stmtUpdate.close();
                if (stmtCheck != null) stmtCheck.close();
                if (conn != null) conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
                System.out.println("Error al cerrar los recursos.");
            }
        }
    }
}
