package com.github.gorkiiuss.program3.recursividad.laberintografo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class CasillaLaberinto {
    private static final Logger logger = Logger.getLogger(CasillaLaberinto.class.getSimpleName());
    private final TipoDeCasillaLaberinto tipo;
    private final HashMap<Direccion, CasillaLaberinto> casillasAdyacentes = new HashMap<>();

    public CasillaLaberinto(TipoDeCasillaLaberinto tipo) {
        this.tipo = tipo;
    }

    public void agregarCasillaAdyacente(Direccion direccion, CasillaLaberinto casillaAdyacente) {
        this.casillasAdyacentes.put(direccion, casillaAdyacente);
    }

    public CasillaLaberinto siguiente(Direccion direccion) {
        return casillasAdyacentes.get(direccion);
    }

    @Override
    public String toString() {
        return String.valueOf(tipo.getImagenCasilla());
    }

    public TipoDeCasillaLaberinto getTipo() {
        return tipo;
    }

    public boolean buscar(TipoDeCasillaLaberinto tipoABuscar, int[] coordenadas, boolean[][] casillasAnalizadas) {
        if (casillasAnalizadas[coordenadas[0]][coordenadas[1]]) {
            logger.warning("Casilla " + coordenadas[0] + ", " + coordenadas[1] + " ya analizada.");
            return false;
        }

        logger.info("Analizando casilla " + coordenadas[0] + ", " + coordenadas[1]);
        casillasAnalizadas[coordenadas[0]][coordenadas[1]] = true;

        if (this.tipo == TipoDeCasillaLaberinto.SALIDA) {
            logger.info("[" + coordenadas[0] + "," + coordenadas[1] + "] Salida encontrada.");
            return true;
        }

        if (this.tipo == TipoDeCasillaLaberinto.MURO) {
            logger.warning("[" + coordenadas[0] + "," + coordenadas[1] + "] Chocado contra muro. Analizando siguiente camino.");
            return false;
        }

        if (this.tipo == TipoDeCasillaLaberinto.ENTRADA) logger.info("[" + coordenadas[0] + "," + coordenadas[1] + "] Iniciando laberinto. Buscando casilla de tipo " + tipoABuscar);

        boolean solucionado = false;
        for (Map.Entry<Direccion, CasillaLaberinto> entry : this.casillasAdyacentes.entrySet()) {
            Direccion direccion = entry.getKey();
            CasillaLaberinto casillaLaberinto = entry.getValue();

            logger.info("[" + coordenadas[0] + "," + coordenadas[1] + "] Accediendo a la casilla de " + direccion);
            solucionado = solucionado || casillaLaberinto.buscar(tipoABuscar, switch (direccion) {
                case ARRIBA -> new int[] { coordenadas[0] - 1, coordenadas[1] };
                case DERECHA -> new int[] { coordenadas[0], coordenadas[1] + 1 };
                case ABAJO -> new int[] { coordenadas[0] + 1, coordenadas[1] };
                case IZQUIERDA -> new int[] {coordenadas[0], coordenadas[1] - 1 };
            }, casillasAnalizadas);
        }

        return solucionado;
    }
}
