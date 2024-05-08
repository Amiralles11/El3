package com.example.EL3.EstructurasDatos.Grafo;

import com.example.EL3.EstructurasDatos.ListaEnlazada.ListaEnlazada;

public class Camino<TipoDato> {
    ListaEnlazada<Vertice<TipoDato>> camino;
    double peso;

    public Camino(ListaEnlazada<Vertice<TipoDato>> camino, double peso) {
        this.camino = camino;
        this.peso = peso;
    }

    public ListaEnlazada<Vertice<TipoDato>> getCamino() {
        return camino;
    }
}
