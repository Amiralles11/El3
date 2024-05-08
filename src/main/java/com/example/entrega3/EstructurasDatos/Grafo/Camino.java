package com.example.entrega3.EstructurasDatos.Grafo;

import com.example.entrega3.EstructurasDatos.ListaEnlazada.ListaEnlazada;

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
