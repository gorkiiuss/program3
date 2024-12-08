package com.github.gorkiiuss.program3.recursividad.laberintografo;

public class Laberinto {
    private final CasillaLaberinto casillaEntrada;
    private final int filaEntrada;
    private final int columnaEntrada = 0; // Siempre es la primera
    private final int filas;
    private final int columnas;

    private Laberinto(CasillaLaberinto casillaEntrada, int filaEntrada, int filas, int columnas) {
        if (casillaEntrada == null || casillaEntrada.getTipo() != TipoDeCasillaLaberinto.ENTRADA) {
            throw new IllegalArgumentException("La casilla de entrada debe ser tal!");
        }

        this.casillaEntrada = casillaEntrada;
        this.filaEntrada = filaEntrada;
        this.filas = filas;
        this.columnas = columnas;
    }

    public boolean solucionar() {
        boolean[][] visitado = new boolean[filas][columnas];
        return casillaEntrada.buscar(TipoDeCasillaLaberinto.SALIDA, new int[] {filaEntrada, columnaEntrada}, visitado);
    }

    public static class Builder {
        private CasillaLaberinto casillaInicial;
        private CasillaLaberinto casillaActual;
        private int filaInicial;
        private int fila = 0;
        private int columna = 0;
        private int filas;
        private int columnas;

        private Builder(int filas, int columnas) {
            this.filas = filas;
            this.columnas = columnas;
        }

        private Builder(CasillaLaberinto casillaActual) {
            this.casillaActual = casillaActual;
        }

        public static Builder init(TipoDeCasillaLaberinto tipo) {
            return new Builder(new CasillaLaberinto(tipo));
        }

        public Builder agregar(Direccion direccion, CasillaLaberinto casilla) {
            // No se puede añadir a la izquierda de la columna de entrada
            if (casillaInicial != null && columna == 0 && direccion == Direccion.IZQUIERDA)
                System.err.println("No se pueden añadir columnas a la izquierda de la entrada!");
            else {
                if (direccion == Direccion.IZQUIERDA) {
                    if (columna == 0) columna++;
                }
                if (direccion == Direccion.ARRIBA) {
                    if (fila == 0) {
                        if (fila == filaInicial) filaInicial++;
                        fila++;
                    }
                }
                casillaActual.agregarCasillaAdyacente(direccion, casilla);
            }
            return this;
        }

        public Builder esCasillaInicial() {
            if (columna != 0)
                System.err.println("Para ser la casilla inicial tiene que estar a la izquierda del todo!");
            else {
                filaInicial = fila;
                casillaInicial = casillaActual;
            }
            return this;
        }

        public Builder siguienteCasilla(Direccion direccion) {
            CasillaLaberinto siguiente = casillaActual.siguiente(direccion);
            if (siguiente == null)
                System.err.println("No hay casilla en esa direccion. Manteniendo casilla actual");
            else {
                switch (direccion) {
                    case ARRIBA -> fila--;
                    case DERECHA -> columna++;
                    case ABAJO -> fila++;
                    case IZQUIERDA -> columna--;
                }
                casillaActual = siguiente;
            }
            return this;
        }

        public static Builder procesarLaberintoEnMatrizDeChars(char[][] laberintoEnMatrizDeChars) {
            int filas = laberintoEnMatrizDeChars.length;
            int columnas = laberintoEnMatrizDeChars[0].length;
            Builder builder = new Builder(filas, columnas);

            CasillaLaberinto[][] casillas = new CasillaLaberinto[filas][columnas];

            // Primera pasada: Crear CasillaLaberinto para cada celda
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    char c = laberintoEnMatrizDeChars[i][j];
                    TipoDeCasillaLaberinto tipo;
                    switch (c) {
                        case 'E':
                            tipo = TipoDeCasillaLaberinto.ENTRADA;
                            break;
                        case 'S':
                            tipo = TipoDeCasillaLaberinto.SALIDA;
                            break;
                        case '#':
                            tipo = TipoDeCasillaLaberinto.MURO;
                            break;
                        case ' ':
                            tipo = TipoDeCasillaLaberinto.PASILLO;
                            break;
                        default:
                            throw new IllegalArgumentException("Caracter desconocido: " + c);
                    }
                    casillas[i][j] = new CasillaLaberinto(tipo);
                    if (tipo == TipoDeCasillaLaberinto.ENTRADA) {
                        if (builder.casillaInicial != null) {
                            throw new IllegalArgumentException("Solo puede haber una casilla de entrada 'E'.");
                        }
                        builder.casillaInicial = casillas[i][j];
                        builder.filaInicial = i;
                    }
                }
            }

            // Segunda pasada: Establecer casillas adyacentes (Incluyendo muros)
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    // Conectar todas las casillas, incluyendo muros
                    // Arriba
                    if (i > 0) {
                        casillas[i][j].agregarCasillaAdyacente(Direccion.ARRIBA, casillas[i - 1][j]);
                    }
                    // Derecha
                    if (j < columnas - 1) {
                        casillas[i][j].agregarCasillaAdyacente(Direccion.DERECHA, casillas[i][j + 1]);
                    }
                    // Abajo
                    if (i < filas - 1) {
                        casillas[i][j].agregarCasillaAdyacente(Direccion.ABAJO, casillas[i + 1][j]);
                    }
                    // Izquierda
                    if (j > 0) {
                        casillas[i][j].agregarCasillaAdyacente(Direccion.IZQUIERDA, casillas[i][j - 1]);
                    }
                }
            }

            // Verificación de la casilla inicial
            if (builder.casillaInicial == null) {
                throw new IllegalArgumentException("No se encontró una casilla de entrada 'E' en el laberinto.");
            }

            // Establecer casillaActual a casillaInicial
            builder.casillaActual = builder.casillaInicial;

            return builder;
        }

        public Laberinto build() {
            if (casillaInicial == null)
                throw new RuntimeException("No se puede iniciar un laberinto sin casilla inicial!");
            return new Laberinto(casillaInicial, filaInicial, filas, columnas);
        }
    }
}
