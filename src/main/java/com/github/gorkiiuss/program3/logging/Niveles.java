package com.github.gorkiiuss.program3.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Niveles {
    private static final Logger logger = Logger.getLogger(Niveles.class.getName());

    public static void main(String[] args) {

        // Por defecto el logger muestra los mensajes a partir de `info`. Si queremos que aparezacan todos, hay que
        // indicarselo:

        logger.setLevel(Level.ALL);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);

        logger.addHandler(handler);
        logger.setUseParentHandlers(false); // evitar que use el `handler` por defecto

        logger.finest("Detalles extremadamente específicos.");
        logger.finer("Más detalles sobre el flujo interno.");
        logger.fine("Información detallada para depuración.");
        logger.config("Configuración inicial del sistema.");
        logger.info("Mensajes informativos generales.");
        logger.warning("Advertencias importantes.");
        logger.severe("Errores críticos.");
    }
}
