package com.example.EL3.EstructurasDatos.Grafo;

import com.example.EL3.EstructurasDatos.ListaEnlazada.ListaEnlazada;

public class Vertice<TipoDato> {
    private TipoDato dato;
    private ListaEnlazada<Arco<TipoDato>> frontera;

    public Vertice(TipoDato dato) {
        this.dato = dato;
        this.frontera = new ListaEnlazada<>();
    }

    public TipoDato getDato() {
        return dato;
    }

    public ListaEnlazada<Arco<TipoDato>> getFrontera() {
        return frontera;
    }


    public void addFrontera(Arco<TipoDato> arco) {
        frontera.add(arco);

    }
}
