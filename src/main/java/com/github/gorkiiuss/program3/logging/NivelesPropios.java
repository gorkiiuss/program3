package com.github.gorkiiuss.program3.logging;

import java.util.logging.*;

public class NivelesPropios {
    public static final Level CRITICAL = new Level("CRITICAL", 1050) {};

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(NivelesPropios.class.getName());
        logger.log(CRITICAL, "Este es un mensaje CRITICAL.");
    }
}
