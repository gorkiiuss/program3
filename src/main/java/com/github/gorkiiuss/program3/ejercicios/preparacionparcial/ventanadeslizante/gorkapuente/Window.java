package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.ventanadeslizante.gorkapuente;

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

        // Crear los botones de movimiento
        WindowMovingButton btnUp = new WindowMovingButton(Direction.UP, this, DEFAULT_SPEED, DEFAULT_TRANSLATION);
        WindowMovingButton btnRight = new WindowMovingButton(Direction.RIGHT, this, DEFAULT_SPEED, DEFAULT_TRANSLATION);
        WindowMovingButton btnDown = new WindowMovingButton(Direction.DOWN, this, DEFAULT_SPEED, DEFAULT_TRANSLATION);
        WindowMovingButton btnLeft = new WindowMovingButton(Direction.LEFT, this, DEFAULT_SPEED, DEFAULT_TRANSLATION);

        // Añadir los botones al JFrame
        add(btnUp, BorderLayout.NORTH);
        add(btnRight, BorderLayout.EAST);
        add(btnDown, BorderLayout.SOUTH);
        add(btnLeft, BorderLayout.WEST);

        // Agregar el KeyListener al JFrame
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w', 'W' -> {
                        if (btnUp.isEnabled()) btnUp.doClick();
                    }
                    case 'a', 'A' -> {
                        if (btnLeft.isEnabled()) btnLeft.doClick();
                    }
                    case 's', 'S' -> {
                        if (btnDown.isEnabled()) btnDown.doClick();
                    }
                    case 'd', 'D' -> {
                        if (btnRight.isEnabled()) btnRight.doClick();
                    }
                }
            }
        });

        // Asegurarse de que el JFrame es enfocable y tiene el foco
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
        this.windowLogger.info("La localización de la ventana es x=" + location.x + " y=" + location.y + ".");
    }

    public void logIsInScreenBorder(Direction direction) {
        this.windowLogger.warning("La ventana está en el borde de " +
                switch (direction) {
                    case UP -> "arriba";
                    case DOWN -> "abajo";
                    case RIGHT -> "la derecha";
                    case LEFT -> "la izquierda";
                } +
                " de la pantalla y no se puede mover!"
        );
    }
}

