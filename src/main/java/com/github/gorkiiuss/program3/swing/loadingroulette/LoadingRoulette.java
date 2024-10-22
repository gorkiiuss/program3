package com.github.gorkiiuss.program3.swing.loadingroulette;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LoadingRoulette extends JPanel {
    private final LoadingRouletteVM viewModel;

    public LoadingRoulette(Loading loadingImage, double spinSpeed, Color spinnerColor) {
        this.viewModel = new LoadingRouletteVM(loadingImage, this, spinSpeed, spinnerColor);
    }

    // Constructor con velocidad de giro predeterminada
    public LoadingRoulette(Loading loadingImage, Color spinnerColor) {
        this(loadingImage, 6.0, spinnerColor); // Velocidad de giro predeterminada de 6 grados por frame
    }

    // Constructor con velocidad de giro y color predeterminados
    public LoadingRoulette(Loading loadingImage) {
        this(loadingImage, 6.0, Color.BLUE); // Color y velocidad predeterminados
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (viewModel.isLoaded()) {
            BufferedImage image = viewModel.getImage();
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        } else {
            Graphics2D g2d = (Graphics2D) g.create();
            viewModel.drawSpinner(g2d, getWidth(), getHeight());
            g2d.dispose();
        }
    }
}
