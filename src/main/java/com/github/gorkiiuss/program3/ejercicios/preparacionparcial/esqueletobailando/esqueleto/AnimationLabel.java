package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.esqueletobailando.esqueleto;

import javax.swing.*;

public class AnimationLabel extends JLabel {
    private final DefaultAnimationLabelModel model;

    public AnimationLabel(String pathToFrames) {
        this.model = new DefaultAnimationLabelModel(this, pathToFrames);
    }

    public DefaultAnimationLabelModel getModel() {
        return this.model;
    }
}
