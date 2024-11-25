package com.github.gorkiiuss.program3.logging;

import java.util.logging.*;

public class OrderSystem {
    private static final Logger logger = Logger.getLogger(OrderSystem.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("Sistema de pedidos iniciado.");

            createOrder("Producto A", 5);
            createOrder("Producto B", -3); // Error
        } catch (Exception e) {
            logger.severe("Excepción en el sistema: " + e.getMessage());
        }
    }

    private static void createOrder(String product, int quantity) {
        if (quantity <= 0) {
            logger.warning("Pedido inválido: cantidad debe ser mayor a 0.");
            return;
        }
        logger.info("Pedido creado: " + product + ", Cantidad: " + quantity);
    }
}
