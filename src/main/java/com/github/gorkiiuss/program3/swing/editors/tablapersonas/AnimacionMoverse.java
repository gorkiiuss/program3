package com.github.gorkiiuss.program3.swing.editors.tablapersonas;

import java.awt.*;

public class AnimacionMoverse extends Thread {
    public AnimacionMoverse(Component component) {
        super(() -> {
            for (int i = 0; i < 10; i ++) {
                component.setLocation(component.getX() + 10, component.getY());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
