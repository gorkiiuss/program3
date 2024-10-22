package com.github.gorkiiuss.program3.swing.loadingroulette;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Loading Roulette");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        MockLoadingImage loadingImage = new MockLoadingImage(5000, "/thumbs_up_emoji.jpg"); // 5 segundos de carga falsa

        // Especificar el color y la velocidad de giro
        Color spinnerColor = Color.BLUE; // Color del spinner
        double spinSpeed = 1.0; // Velocidad de giro en grados por frame

        LoadingRoulette loadingRoulette = new LoadingRoulette(loadingImage, spinSpeed, spinnerColor);

        frame.add(loadingRoulette, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
