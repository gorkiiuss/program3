package com.github.gorkiiuss.program3.io.lang;

public class ModeloDeLaVistaPanelIdioma extends Observable {
    private String idiomaElegido;

    public String getIdiomaElegido() {
        return idiomaElegido;
    }

    public void setIdiomaElegido(String idiomaElegido) {
        this.idiomaElegido = idiomaElegido;
        notifyObservers();
    }
}
