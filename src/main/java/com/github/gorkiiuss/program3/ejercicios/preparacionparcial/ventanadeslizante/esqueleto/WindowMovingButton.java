package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.ventanadeslizante.esqueleto;

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
            // Con este metodo el boton no se puede pulsar mientras se ejecuta la animacion
            setEnabled(false);

            // TODO: Implementa el codigo necesario de la **ANIMACION** para que la ventana se mueva. Hazlo teniendo en
            //  cuenta tódo lo siguiente:
            //      1. Una vez el bucle de la animacion acabe, es necesario ejecutar un `setEnabled(true)` para que el
            //      boton vuelva a estar disponible.
            //      2. Utiliza la velocidad y la traslacion pasada por parametro para mover la ventana, asi como el
            //      metodo `setLocation` del parametro `window`.
            //      3. Realiza las iteraciones del bucle cada 16 milisegundos.
            //      4. La ventana no se debe mover si esta en el borde de la pantalla hacia el que pretende hacerlo. Es
            //      decir, si esta en el borde izquierdo no se podra mover hacia la izquierda y demas. **REVISA EL
            //      CODIGO DE LA CLASE `Window` PARA VER SI HAY ALGUN METODO UTIL PARA ESTO.

            // TODO: Una vez se acabe la implementacion de la animacion y sea funcional, hacer que al finalizar se
            //  loggee lo siguiente:
            //      1. La localizacion en la que la ventana ha acabado.
            //      2. Si no se ha podido mover del borde de la pantalla, un mensaje de advertencia.
        });
    }
}

