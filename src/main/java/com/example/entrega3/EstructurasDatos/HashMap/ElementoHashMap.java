package com.example.entrega3.EstructurasDatos.HashMap;

public class ElementoHashMap<T, E> {
    private T indice;
    private E dato;
    private ElementoHashMap<T, E> siguiente;

    public ElementoHashMap(T indice, E dato, ElementoHashMap<T, E> siguiente) {
        this.indice = indice;
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public T getIndice() {
        return indice;
    }

    public E getDato() {
        return dato;
    }

    public ElementoHashMap<T, E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ElementoHashMap<T, E> siguiente) {
        this.siguiente = siguiente;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }
}
