package com.github.gorkiiuss.program3.parcial2024.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaDeOrganismos {
    private final ArrayList<Organismo> lista = new ArrayList<>();
    private int avaliableIdx = 0;

    public ListaDeOrganismos() {

    }

    public Organismo get(int idx) {
        return lista.get(idx);
    }

    public Class<? extends Organismo> getTipoDeOrganismo(int idx) {
        return lista.get(idx).getClass();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public void setLista(Organismo[] organismos) {
        this.lista.clear();
        this.lista.addAll(List.of(organismos));
        avaliableIdx = this.lista.size();
    }

    public int size() {
        return lista.size();
    }

    public void add(Organismo organismo) {
        lista.add(organismo);
        avaliableIdx++;
    }

    public Organismo duplicate(int idx) {
        return lista.get(idx).from(avaliableIdx);
    }

    public int getAvaliableIdx() {
        return avaliableIdx;
    }

    public void remove(int idx) {
        this.lista.remove(idx);
    }

    public Organismo[] getLista() {
        return lista.toArray(new Organismo[0]);
    }

    public void clear() {
        this.lista.clear();
    }

    public Organismo[] toArray() {
        return lista.toArray(new Organismo[0]);
    }
}
