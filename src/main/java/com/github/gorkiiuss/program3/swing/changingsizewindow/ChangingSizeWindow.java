package com.github.gorkiiuss.program3.swing.changingsizewindow;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChangingSizeWindow extends JFrame {
    private JButton boton;
    private int maxWidth = 800;
    private int maxHeight = 600;
    private int minWidth = 600;
    private int minHeight = 400;

    private boolean isBig = true;

    public ChangingSizeWindow() {
        boton = new JButton("Cambiar tamaño");
        setSize(maxWidth, maxHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boton.addActionListener(e -> launchAnimation(e, this));
        add(boton);
    }

    private void launchAnimation(ActionEvent actionEvent, ChangingSizeWindow window) {
        new Thread( () -> {
            while (
                    isBig && (window.getSize().width >= window.minWidth || window.getSize().height >= window.minHeight) ||
                    !isBig && (window.getSize().width <= window.maxWidth || window.getSize().height <= window.minHeight)
            ) {
                if (isBig) {
                    window.setSize(window.maxWidth - 5, window.maxHeight - 5);
                } else {
                    window.setSize(window.maxWidth + 5, window.maxHeight + 5);
                }

                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        isBig = !isBig;
    }
}
