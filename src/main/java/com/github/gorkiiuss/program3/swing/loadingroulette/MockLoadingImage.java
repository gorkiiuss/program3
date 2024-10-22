package com.github.gorkiiuss.program3.swing.loadingroulette;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class MockLoadingImage implements Loading {

    private BufferedImage image;
    private volatile boolean loaded;
    private final List<Runnable> loadedCallbacks = new ArrayList<>();
    private final String imagePath;

    public MockLoadingImage(long loadingTimeMillis, String imagePath) {
        this.imagePath = imagePath;
        this.loaded = false;

        new Thread(() -> {
            try {
                Thread.sleep(loadingTimeMillis);
                image = ImageIO.read(getClass().getResource(imagePath));
                loaded = true;
                // Ejecutar las callbacks
                List<Runnable> callbacksToRun;
                synchronized (this) {
                    callbacksToRun = new ArrayList<>(loadedCallbacks);
                    loadedCallbacks.clear();
                }
                for (Runnable callback : callbacksToRun) {
                    callback.run();
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }

    @Override
    public synchronized void executeWhenLoaded(Runnable action) {
        if (loaded) {
            action.run();
        } else {
            loadedCallbacks.add(action);
        }
    }
}
