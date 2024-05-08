package com.example.entrega3.EstructurasDatos.Grafo;

import com.example.entrega3.EstructurasDatos.ListaEnlazada.ListaEnlazada;

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
