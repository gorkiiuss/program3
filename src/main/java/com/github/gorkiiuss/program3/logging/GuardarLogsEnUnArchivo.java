package com.github.gorkiiuss.program3.logging;

import java.util.logging.*;

public class GuardarLogsEnUnArchivo {
    private static final Logger logger = Logger.getLogger(GuardarLogsEnUnArchivo.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/logger/app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            logger.info("Log registrado en el archivo.");
        } catch (Exception e) {
            logger.severe("Error al configurar FileHandler: " + e.getMessage());
        }
    }
}
