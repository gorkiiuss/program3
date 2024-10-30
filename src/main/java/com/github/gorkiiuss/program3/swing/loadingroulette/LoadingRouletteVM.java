package com.github.gorkiiuss.program3.swing.loadingroulette;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

public class LoadingRouletteVM {
    private final Loading loading;
    private final Component component;
    private BufferedImage image;
    private double angle; // en grados
    private Thread animationThread;
    private final double spinSpeed; // grados por frame
    private final Color spinnerColor;

    public LoadingRouletteVM(Loading loading, Component component, double spinSpeed, Color spinnerColor) {
        this.loading = loading;
        this.component = component;
        this.spinSpeed = spinSpeed;
        this.spinnerColor = spinnerColor;
        this.angle = 0;

        // Iniciar el hilo de animación
        animationThread = new Thread(() -> {
            try {
                while (!loading.isLoaded()) {
                    angle += spinSpeed;
                    if (angle >= 360) {
                        angle -= 360;
                    }
                    component.repaint();
                    Thread.sleep(16); 
                    // Aproximadamente 60 fps
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        animationThread.start();

        // Cuando la carga termine, obtener la imagen y detener la animación
        loading.executeWhenLoaded(() -> {
            if (loading instanceof MockLoadingImage) {
                image = ((MockLoadingImage) loading).getImage();
            }
            animationThread.interrupt();
            component.repaint();
        });
    }

    public boolean isLoaded() {
        return loading.isLoaded();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void drawSpinner(Graphics2D g2d, int width, int height) {
        int size = Math.min(width, height) / 4;
        int thickness = size / 4; // Grosor del anillo

        // Habilitar anti-aliasing para un dibujo más suave
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Guardar la transformación actual
        AffineTransform old = g2d.getTransform();

        // Trasladar al centro del componente
        g2d.translate(width / 2, height / 2);

        // Rotar según el ángulo actual
        g2d.rotate(Math.toRadians(angle));

        // Dibujar el anillo con gradiente de alfa
        int segments = 60; // Número de segmentos para simular el gradiente
        for (int i = 0; i < segments; i++) {
            float fraction = (float) i / segments;
            int alpha = (int) (255 * (1 - fraction)); // De 255 (opaco) a 0 (transparente)

            // Asegurarse de que el alfa esté en el rango válido
            alpha = Math.max(0, Math.min(255, alpha));

            Color colorWithAlpha = new Color(
                    spinnerColor.getRed(),
                    spinnerColor.getGreen(),
                    spinnerColor.getBlue(),
                    alpha
            );

            // Configurar el color del segmento
            g2d.setColor(colorWithAlpha);

            // Calcular el ángulo inicial y final del segmento
            double startAngle = (i * 360.0 / segments);
            double arcAngle = 360.0 / segments;

            // Dibujar el segmento del anillo
            Shape segment = new Arc2D.Double(
                    -size / 2.0, -size / 2.0, // x, y (centrado en origen)
                    size, size, // ancho, alto
                    startAngle, arcAngle, // ángulo inicial y amplitud
                    Arc2D.OPEN
            );

            Stroke originalStroke = g2d.getStroke();
            g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            g2d.draw(segment);
            g2d.setStroke(originalStroke);
        }

        // Restaurar la transformación original
        g2d.setTransform(old);
    }
}
