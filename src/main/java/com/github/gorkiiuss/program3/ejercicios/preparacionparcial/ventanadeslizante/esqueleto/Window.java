package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.ventanadeslizante.esqueleto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

public class Window extends JFrame {
    private final Logger windowLogger = Logger.getLogger(Window.class.getName());
    private static final int DEFAULT_SPEED = 5;
    private static final int DEFAULT_TRANSLATION = 100;

    public Window() {
        super("Ventana deslizante");
        setSize(new Dimension(200, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // TODO: Crear los cuatro botones de movimiento y añadirlos al JFrame en las posiciones correspondientes

        // TODO: Tarea suplementaria
        //  Agregar el KeyListener al JFrame para poder pulsar los botones con las teclas WASD del teclado (Leer sobre
        //  el metodo `doClick` de la clase `JButton`). Para que la implementacion funcione coherentemente es necesario
        //  comprobar que el boton este disponible (Leer sobre el metodo `isEnabled` de la clase `JButton`).

        // Asegurarse de que el JFrame es enfocable y tiene el foco. Estas dos lineas de codigo son imprescindibles si
        // se quiere que el JFrame responda a las entradas por teclado
        setFocusable(true);
        requestFocusInWindow();
    }

    public boolean isInScreenBorderForDirection(Direction direction) {
        Point location = this.getLocation();
        Dimension componentSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        return switch (direction) {
            case UP -> location.y == 0;
            case DOWN -> (location.y + componentSize.height) >= screenSize.height;
            case LEFT -> location.x == 0;
            case RIGHT -> (location.x + componentSize.width) >= screenSize.width;
        };
    }

    public void logLocation() {
        Point location = this.getLocation();
        // TODO: Hacer que el logger muestre la informacion de la localizacion de la ventana
    }

    public void logIsInScreenBorder(Direction direction) {
        // TODO: Hacer que el logger muestre la informacion de en que borde de la pantalla esta la ventana.
        //  Por ejemplo, si la ventana esta en el borde superior debera mostrarse el mensaje `La ventana está en el
        //  borde de arriba de la pantalla y no se puede mover!`. Este mensaje dependera de la direccion que viene por
        //  parametro. Ten en cuenta que tipo de mensaje es el que el logger tiene que mostrar!
    }
}

