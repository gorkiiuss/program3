package com.github.gorkiiuss.program3.io.lang;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Objects;

public class PanelConversacion extends JPanel implements Observer {
    private static final Icon ICONO_ASISTENTE = new ImageIcon(Objects.requireNonNull(PanelConversacion.class.getResource("/io/lang/asistente.png")));
    private static final Icon ICONO_USUARIO = new ImageIcon(Objects.requireNonNull(PanelConversacion.class.getResource("/io/lang/usuario.png")));

    private ModeloDeLaVistaPanelIdioma modelo;
    private Map<String, String> mensajesMap; // Mapa de mensajes en el idioma actual
    private String idiomaActual;

    // Componentes de la interfaz
    private JPanel panelMensajes;
    private JScrollPane scrollPane;

    // Lista de mensajes de la conversación
    private List<MensajeEnviado> listaMensajes;

    // Variables de instancia para los botones de opciones
    private JButton btnOpcion1;
    private JButton btnOpcion2;
    private JButton btnOpcion3;

    public PanelConversacion() {
        this.setLayout(new BorderLayout());

        panelMensajes = new JPanel();
        panelMensajes.setLayout(new BoxLayout(panelMensajes, BoxLayout.Y_AXIS));
        panelMensajes.setBackground(Color.WHITE);

        scrollPane = new JScrollPane(panelMensajes);
        scrollPane.setBorder(null);
        this.add(scrollPane, BorderLayout.CENTER);

        listaMensajes = new ArrayList<>();

        // Mostrar el mensaje inicial
        mostrarMensajeSeleccionIdioma();
    }

    private void mostrarMensajeSeleccionIdioma() {
        panelMensajes.removeAll();
        listaMensajes.clear();

        JLabel mensajeInicial = new JLabel(
                "<html>Por favor, selecciona un idioma /<br/>Please select a language /<br/>Mesedez, aukeratu hizkuntza</html>",
                ICONO_ASISTENTE, JLabel.LEFT);

        agregarMensajeAlPanel(mensajeInicial, false, null);

        revalidate();
        repaint();
    }

    private void agregarMensajeDelAsistente(String idMensaje, Map<String, String> placeholders) {
        String mensaje = mensajesMap.get(idMensaje);
        if (mensaje == null) {
            mensaje = "Mensaje no disponible";
        } else if (placeholders != null) {
            for (Map.Entry<String, String> entry : placeholders.entrySet()) {
                mensaje = mensaje.replace(entry.getKey(), entry.getValue());
            }
        }

        JLabel lblMensaje = crearLabelMensaje(mensaje, ICONO_ASISTENTE, Color.BLUE, new Color(220, 240, 255));
        agregarMensajeAlPanel(lblMensaje, false, new MensajeEnviado(idMensaje, false, placeholders, lblMensaje));
    }

    private void agregarMensajeDelUsuario(String idMensaje) {
        String mensaje = mensajesMap.get(idMensaje);
        if (mensaje == null) {
            mensaje = "Mensaje no disponible";
        }

        JLabel lblMensaje = crearLabelMensaje(mensaje, ICONO_USUARIO, Color.GREEN, new Color(220, 255, 220));
        agregarMensajeAlPanel(lblMensaje, true, new MensajeEnviado(idMensaje, true, null, lblMensaje));
    }

    private JLabel crearLabelMensaje(String mensaje, Icon icono, Color colorBorde, Color colorFondo) {
        JLabel lblMensaje = new JLabel("<html>" + mensaje + "</html>");
        lblMensaje.setIcon(icono);
        lblMensaje.setOpaque(true);
        lblMensaje.setBackground(colorFondo);
        lblMensaje.setBorder(crearBordeMensaje(colorBorde));
        lblMensaje.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        lblMensaje.setPreferredSize(new Dimension(500, lblMensaje.getPreferredSize().height));

        return lblMensaje;
    }

    private void agregarMensajeAlPanel(JComponent componente, boolean esUsuario, MensajeEnviado mensajeEnviado) {
        JPanel panelContenedor = new JPanel(new BorderLayout());
        panelContenedor.setOpaque(false);

        if (esUsuario) {
            panelContenedor.add(componente, BorderLayout.EAST);
        } else {
            panelContenedor.add(componente, BorderLayout.WEST);
        }

        panelMensajes.add(panelContenedor);
        panelMensajes.add(Box.createVerticalStrut(10)); // Espacio entre mensajes

        if (mensajeEnviado != null) {
            listaMensajes.add(mensajeEnviado);
        }

        revalidate();
        repaint();

        // Desplazar el scroll hacia abajo
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()));
    }

    private Border crearBordeMensaje(Color color) {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color, 1, true),
                new EmptyBorder(5, 10, 5, 10)
        );
    }

    private void mostrarOpciones() {
        // Crear un panel para las opciones
        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelOpciones.setOpaque(false);

        // Crear botones para cada opción y asignarlos a las variables de instancia
        btnOpcion1 = new JButton(mensajesMap.get("opcion1"));
        btnOpcion2 = new JButton(mensajesMap.get("opcion2"));
        btnOpcion3 = new JButton(mensajesMap.get("opcion3"));

        // Establecer action commands (opcional, si los necesitas para otra cosa)
        btnOpcion1.setActionCommand("opcion1");
        btnOpcion2.setActionCommand("opcion2");
        btnOpcion3.setActionCommand("opcion3");

        // Añadir ActionListeners a los botones
        btnOpcion1.addActionListener(e -> realizarAccionOpcion1());
        btnOpcion2.addActionListener(e -> realizarAccionOpcion2());
        btnOpcion3.addActionListener(e -> realizarAccionOpcion3());

        // Añadir los botones al panel de opciones
        panelOpciones.add(btnOpcion1);
        panelOpciones.add(btnOpcion2);
        panelOpciones.add(btnOpcion3);

        // Añadir el panel de opciones al panel de mensajes
        agregarMensajeAlPanel(panelOpciones, false, new MensajeEnviado("opciones", false, null, panelOpciones));
    }

    private void realizarAccionOpcion1() {
        // El usuario selecciona la opción 1
        agregarMensajeDelUsuario("opcion1");

        // Simular tiempo de espera del asistente (1 segundo) y respuesta
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException ignored) {
            }

            // Obtener datos del clima actual (inventados)
            obtenerDatosClimaActual();

            // Crear placeholders
            Map<String, String> placeholders = new HashMap<>();
            placeholders.put("{ciudad}", ciudad);
            placeholders.put("{descripcion}", descripcionClima);
            placeholders.put("{temperatura}", temperatura);

            // Mostrar mensaje del asistente con el clima actual en el EDT
            SwingUtilities.invokeLater(() -> {
                agregarMensajeDelAsistente("clima_actual", placeholders);

                // Esperar 0.5 segundos antes de preguntar de nuevo
                new Thread(() -> {
                    try {
                        Thread.sleep(500); // Esperar 0.5 segundos
                    } catch (InterruptedException ignored) {
                    }

                    SwingUtilities.invokeLater(this::iniciarConversacion);
                }).start();
            });
        }).start();
    }

    private void realizarAccionOpcion2() {
        // El usuario selecciona la opción 2
        agregarMensajeDelUsuario("opcion2");

        // Simular tiempo de espera del asistente (1 segundo) y respuesta
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException ignored) {
            }

            // Obtener datos de la previsión (inventados)
            obtenerDatosPrevision();

            // Crear placeholders
            Map<String, String> placeholders = new HashMap<>();
            placeholders.put("{descripcion}", descripcionClima);
            placeholders.put("{min}", tempMin);
            placeholders.put("{max}", tempMax);

            // Mostrar mensaje del asistente con la previsión en el EDT
            SwingUtilities.invokeLater(() -> {
                agregarMensajeDelAsistente("prevision", placeholders);

                // Esperar 0.5 segundos antes de preguntar de nuevo
                new Thread(() -> {
                    try {
                        Thread.sleep(500); // Esperar 0.5 segundos
                    } catch (InterruptedException ignored) {
                    }

                    SwingUtilities.invokeLater(this::iniciarConversacion);
                }).start();
            });
        }).start();
    }

    private void realizarAccionOpcion3() {
        // El usuario selecciona la opción 3
        agregarMensajeDelUsuario("opcion3");

        // Simular tiempo de espera del asistente (1 segundo) y respuesta
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException ignored) {
            }

            // Mostrar mensaje de despedida del asistente en el EDT
            SwingUtilities.invokeLater(() -> {
                agregarMensajeDelAsistente("despedida", null);

                // Esperar 0.5 segundos antes de cerrar la aplicación
                new Thread(() -> {
                    try {
                        Thread.sleep(500); // Esperar 0.5 segundos
                    } catch (InterruptedException ignored) {
                    }

                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(this, mensajesMap.get("despedida"));
                        System.exit(0);
                    });
                }).start();
            });
        }).start();
    }

    private void iniciarConversacion() {
        // Mostrar saludo
        agregarMensajeDelAsistente("saludo", null);

        // Mostrar opciones
        mostrarOpciones();
    }

    // Variables para datos del clima
    private String ciudad;
    private String descripcionClima;
    private String temperatura;
    private String tempMin;
    private String tempMax;

    private void obtenerDatosClimaActual() {
        // Datos inventados según el idioma
        switch (idiomaActual) {
            case "es_ES":
                ciudad = "Madrid";
                descripcionClima = "soleado";
                temperatura = "25";
                break;
            case "eus_EUS":
                ciudad = "Bilbo";
                descripcionClima = "eguzkitsua";
                temperatura = "22";
                break;
            case "us_EN":
                ciudad = "London";
                descripcionClima = "cloudy";
                temperatura = "18";
                break;
            default:
                ciudad = "Unknown";
                descripcionClima = "unknown";
                temperatura = "0";
                break;
        }
    }

    private void obtenerDatosPrevision() {
        // Datos inventados según el idioma
        switch (idiomaActual) {
            case "es_ES":
                descripcionClima = "parcialmente nublado";
                tempMin = "15";
                tempMax = "28";
                break;
            case "eus_EUS":
                descripcionClima = "hodeitsua";
                tempMin = "12";
                tempMax = "25";
                break;
            case "us_EN":
                descripcionClima = "rainy";
                tempMin = "10";
                tempMax = "20";
                break;
            default:
                descripcionClima = "unknown";
                tempMin = "0";
                tempMax = "0";
                break;
        }
    }

    @Override
    public void update(Observable observable, Object[] args) {
        if (!(observable instanceof ModeloDeLaVistaPanelIdioma modeloDeLaVistaPanelIdioma))
            return;

        this.modelo = modeloDeLaVistaPanelIdioma;
        this.idiomaActual = modelo.getIdiomaElegido();

        // Cargar los mensajes en el idioma elegido
        Mensaje[] mensajesArray = GestorDeIdiomas.cargarMensajes(idiomaActual);

        if (mensajesArray == null || mensajesArray.length == 0) {
            JOptionPane.showMessageDialog(this, "Error al cargar los mensajes en el idioma seleccionado.");
            return;
        }

        // Crear un mapa de mensajes para acceso rápido por ID
        mensajesMap = new HashMap<>();
        for (Mensaje mensaje : mensajesArray) {
            mensajesMap.put(mensaje.id(), mensaje.msg());
        }

        // Verificar si es la primera vez que se selecciona un idioma
        if (listaMensajes.isEmpty()) {
            // Iniciar la conversación
            iniciarConversacion();
        } else {
            // Actualizar los mensajes existentes al nuevo idioma
            actualizarMensajesAlNuevoIdioma();
        }
    }

    private void actualizarMensajesAlNuevoIdioma() {
        for (MensajeEnviado mensajeEnviado : listaMensajes) {
            String nuevoTexto = mensajesMap.get(mensajeEnviado.idMensaje);
            if (nuevoTexto == null) {
                nuevoTexto = "Mensaje no disponible";
            } else if (mensajeEnviado.placeholders != null) {
                for (Map.Entry<String, String> entry : mensajeEnviado.placeholders.entrySet()) {
                    nuevoTexto = nuevoTexto.replace(entry.getKey(), entry.getValue());
                }
            }

            mensajeEnviado.actualizarTexto("<html>" + nuevoTexto + "</html>");
        }

        // Actualizar los textos de los botones de opciones
        if (btnOpcion1 != null) {
            btnOpcion1.setText(mensajesMap.get("opcion1"));
        }
        if (btnOpcion2 != null) {
            btnOpcion2.setText(mensajesMap.get("opcion2"));
        }
        if (btnOpcion3 != null) {
            btnOpcion3.setText(mensajesMap.get("opcion3"));
        }

        revalidate();
        repaint();
    }

    // Clase interna para almacenar información de los mensajes enviados
    private static class MensajeEnviado {
        String idMensaje;
        boolean esUsuario;
        Map<String, String> placeholders;
        JComponent componente;

        MensajeEnviado(String idMensaje, boolean esUsuario, Map<String, String> placeholders, JComponent componente) {
            this.idMensaje = idMensaje;
            this.esUsuario = esUsuario;
            this.placeholders = placeholders != null ? new HashMap<>(placeholders) : null;
            this.componente = componente;
        }

        void actualizarTexto(String nuevoTexto) {
            if (componente instanceof JLabel lbl) {
                lbl.setText(nuevoTexto);
            }
        }
    }
}
