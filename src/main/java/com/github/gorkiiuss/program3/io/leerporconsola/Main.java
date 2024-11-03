package com.github.gorkiiuss.program3.io.leerporconsola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("¿Cuántos años tienes? ");
            String respuesta = reader.readLine();

            // TODO: Comprobar que el usuario haya introducido bien la edad, es decir, el numero.
            int edad = Integer.parseInt(respuesta);

            if (edad < 18)
                System.out.println("Legalmente no puedes beber alcohol,... legalmente.");
            else System.out.println("¡Legalmente puedes beber alcohol!");

        } catch (IOException ignored) {

        }
    }
}
