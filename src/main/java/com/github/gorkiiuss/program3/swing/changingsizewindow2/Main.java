package com.github.gorkiiuss.program3.swing.changingsizewindow2;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Changing Size Window");
        JFrame frame = new JFrame("Changing Size Window");

        frame.setSize(800, 600);

        JButton button = new JButton("Púlsame");
        button.addActionListener(e -> {
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                int minValue = 200;

                int speed = 10;
                int repetitions = 10;

                int width = frame.getWidth();
                int height = frame.getHeight();

                if (width - speed * repetitions < minValue || height - speed * repetitions < minValue) {
                    logger.warning("Te vas a pasar de listo!");
                    JOptionPane.showMessageDialog(
                            null,
                            "Te vas a pasar de listo!",
                            "Cuidao",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }


                for (int i = 0; i < repetitions; i++) {
                    width -= speed;
                    height -= speed;

                    frame.setSize(width, height);

                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                logger.info("width=" + width + ", height=" + height);
            }).start();
        });
        frame.add(button, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
