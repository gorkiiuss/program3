package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.esqueletobailando.gorkapuentemejorado;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        super("Esqueleto Bailando");
        setSize(220, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        AnimationLabel animationLabel = new AnimationLabel("/ejercicios/preparacionparcial/esqueletobailando/");
        JButton btnAnimation = getBtnAnimation(animationLabel);

        add(animationLabel, BorderLayout.CENTER);
        add(btnAnimation, BorderLayout.SOUTH);
    }

    private static JButton getBtnAnimation(AnimationLabel animationLabel) {
        JButton btnAnimation = new JButton("Empezar animación");
        btnAnimation.addActionListener(e -> {
            DefaultAnimationLabelModel model = animationLabel.getModel();
            // TODO: añadir logica para cambiar el estado de `playing`
            if (model.isPlaying()) {
                btnAnimation.setText("Empezar animación");
            }
            else {
                btnAnimation.setText("Para animación");
            }
            animationLabel.getModel().togglePlaying();
        });
        return btnAnimation;
    }
}
