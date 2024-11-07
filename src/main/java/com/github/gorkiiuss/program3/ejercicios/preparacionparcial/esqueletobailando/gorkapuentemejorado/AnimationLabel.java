package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.esqueletobailando.gorkapuentemejorado;

import javax.swing.*;
import java.awt.*;

public class AnimationLabel extends JLabel {
    private final DefaultAnimationLabelModel model;

    public AnimationLabel(String pathToFrames) {
        this.model = new DefaultAnimationLabelModel(this, pathToFrames);
        /*
          Tambien es necesario hacer el componente opaco para que no parpadee. Asi, pinta la imagen completa en cada
          frame de la animacion.
         */
        setOpaque(true);
        setIcon(this.model.getFrame());
    }

    public DefaultAnimationLabelModel getModel() {
        return this.model;
    }

    /**
     * Este `@Override` sirve para que la etiqueta no borre la imagen anteriormente pintada y asi no parpadee
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        if (getIcon() != null)
            getIcon().paintIcon(this, g, 0, 0);
    }
}
