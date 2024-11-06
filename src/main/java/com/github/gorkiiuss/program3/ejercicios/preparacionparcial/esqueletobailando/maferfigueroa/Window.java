package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.esqueletobailando.maferfigueroa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        super("Esqueleto Bailando");
        setSize(220, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        AnimationLabel animationLabel = new AnimationLabel("/ejercicios/preparacionparcial/esqueletobailando/");
        JButton btnAnimation = new JButton("Empezar animación");
        btnAnimation.addActionListener(e -> {
            DefaultAnimationLabelModel model = animationLabel.getModel();
            if (model.isPlaying()) {
                btnAnimation.setText("Empezar animación");
                animationLabel.getModel().togglePlaying();
            } else {
                btnAnimation.setText("Para animación");
                animationLabel.getModel().togglePlaying();
            }
        });
        
//        setLayout(new GridLayout(2,1));
//        
//        add(animationLabel);
//        add(btnAnimation);
//        
        
        setLayout(new BorderLayout());
        add(animationLabel,BorderLayout.CENTER);
        add(btnAnimation, BorderLayout.SOUTH);
    }
}
