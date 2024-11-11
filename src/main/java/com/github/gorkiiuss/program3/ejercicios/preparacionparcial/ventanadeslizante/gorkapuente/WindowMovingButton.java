package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.ventanadeslizante.gorkapuente;

import javax.swing.*;
import java.awt.*;

public class WindowMovingButton extends JButton {
    private final Direction direction;
    private final Window window;
    private final int speedInPxPerFrame;
    private final int translationInPx;

    public WindowMovingButton(Direction direction, Window window, int speedInPxPerFrame, int translationInPx) {
        this.direction = direction;
        this.window = window;
        this.speedInPxPerFrame = speedInPxPerFrame;
        this.translationInPx = translationInPx;

        setText(direction.getText());

        setFont(getFont().deriveFont(Font.BOLD, 32));

        addActionListener(e -> {
            setEnabled(false);
            new Thread(() -> {
                int initialLocationX = this.window.getLocation().x;
                int initialLocationY = this.window.getLocation().y;
                Point currentLocation = this.window.getLocation();
                while ((currentLocation.distance(initialLocationX, initialLocationY) < translationInPx) &&
                        !window.isInScreenBorderForDirection(direction)) {
                    switch (direction) {
                        case UP -> currentLocation.translate(0, -speedInPxPerFrame);
                        case DOWN -> currentLocation.translate(0, speedInPxPerFrame);
                        case LEFT -> currentLocation.translate(-speedInPxPerFrame, 0);
                        case RIGHT -> currentLocation.translate(speedInPxPerFrame, 0);
                    }
                    this.window.setLocation(currentLocation);
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException ignored) {
                    }
                }

                if (window.isInScreenBorderForDirection(direction))
                    window.logIsInScreenBorder(direction);

                window.logLocation();

                setEnabled(true);
            }).start();
        });
    }
}

