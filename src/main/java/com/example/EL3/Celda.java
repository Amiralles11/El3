package com.example.EL3;

import com.example.EL3.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.example.EL3.EstructurasDatos.ListaSimple.ListaSimple;

public class Celda {
    private final ListaSimple<Integer> coordenadas = new ListaSimple<>(2);
    private ListaEnlazada<Individuo> individuos = new ListaEnlazada<>();
    private ListaEnlazada<Recurso> recursos = new ListaEnlazada<>();

    public Celda(int fila, int columna) {
        this.coordenadas.add(fila);
        this.coordenadas.add(columna);

    }

    public Integer getFilas() {
        return coordenadas.getElemento(0).getData();
    }
    public Integer getColumnas() {
        return coordenadas.getElemento(1).getData();
    }

    @Override
    public String toString() {
        return "Celda("+(getFilas()+1)+","+(getColumnas()+1)+"){" +
                "coordenadas=" + coordenadas +
                ", individuos=" + individuos +
                ", recursos=" + recursos +
                '}';
    }
    protected void add(Individuo individuo){
        individuos.add(individuo);
    }
    protected void add(Recurso recurso){
        recursos.add(recurso);
    }

    public ListaEnlazada<Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(ListaEnlazada<Individuo> individuos) {
        this.individuos = individuos;
    }

    public ListaEnlazada<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(ListaEnlazada<Recurso> recursos) {
        this.recursos = recursos;
    }
}