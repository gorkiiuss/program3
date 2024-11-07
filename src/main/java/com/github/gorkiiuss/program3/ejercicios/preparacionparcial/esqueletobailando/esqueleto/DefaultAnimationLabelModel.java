package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.esqueletobailando.esqueleto;

import javax.swing.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultAnimationLabelModel {
    private final AnimationLabel view;
    private boolean playing;
    private int frame;
    private final Icon[] frameImages;
    // TODO: añadir el thread aqui como variable y pararlo y continuarlo cuando queramos

    public DefaultAnimationLabelModel(AnimationLabel view, String pathToFrames) {
        this.view = view;

        URL url = DefaultAnimationLabelModel.class.getResource("/ejercicios/preparacionparcial/esqueletobailando");
        if (url == null) {
            frameImages = null;
            return;
        }

        File framesDirectory = null;
        try {
            framesDirectory = new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("No se ha encontrado el directorio");
        }

        if (!framesDirectory.exists() || !framesDirectory.isDirectory()) {
            System.err.println("No se ha encontrado el directorio o no es un directorio: " + framesDirectory);
            frameImages = null;
            return;
        }

        Pattern pattern = Pattern.compile("^frame_(\\d+)\\.gif$");
        File[] matchingFiles = framesDirectory.listFiles((dir, name) -> pattern.matcher(name).matches());

        if (matchingFiles == null || matchingFiles.length == 0) {
            System.err.println("No se ha encontrado ningun fichero dentro que siga la estructura definida");
            frameImages = null;
            return;
        }

        Arrays.sort(matchingFiles, (file1, file2) -> {
            Matcher matcher1 = pattern.matcher(file1.getName());
            Matcher matcher2 = pattern.matcher(file2.getName());

            if (matcher1.matches() && matcher2.matches()) {
                int index1 = Integer.parseInt(matcher1.group(1));
                int index2 = Integer.parseInt(matcher2.group(1));
                return Integer.compare(index1, index2);
            } else {
                return file1.getName().compareTo(file2.getName());
            }
        });

        this.frameImages = new Icon[matchingFiles.length];
        for (int i = 0; i < matchingFiles.length; i++) {
            this.frameImages[i] = new ImageIcon(matchingFiles[i].getAbsolutePath());
        }

        /*
         TODO: Crear hilo e indicarle que es lo que tiene que ejecutar. Si isPLaying entonces el bucle del hilo no hara
          nada. Sino, tendra que mostrar el siguiente frame de la animacion. Cuando el bucle no haga nada debe tener un
          `sleep` para que la CPU no se sobrecargue.
        */
    }

    public boolean isPlaying() {
        return playing;
    }

    public void togglePlaying() {
        playing = !playing;
    }
}
