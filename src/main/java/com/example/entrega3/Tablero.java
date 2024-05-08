package com.example.entrega3;

import com.example.entrega3.EstructurasDatos.ListaSimple.ListaSimple;
public class Tablero {
    ListaSimple<Integer> dimensiones = new ListaSimple<>(2);

    public Tablero(Integer filas, Integer columnas) {
        this.dimensiones.add(filas);
        this.dimensiones.add(columnas);
    }

    public ListaSimple<Integer> getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(ListaSimple<Integer> dimensiones) {
        this.dimensiones = dimensiones;
    }
    public int getFilas() {
        return dimensiones.getElemento(0).getData();
    }
    public int getColumnas() {
        return dimensiones.getElemento(1).getData();
    }
    public void setFilas(int filas) {
        dimensiones.getElemento(0).setData(filas);
    }
    public void setColumnas(int columnas) {
        dimensiones.getElemento(1).setData(columnas);
    }
    @Override
    public String toString() {
        return "Filas: " + dimensiones.getElemento(0).getData() +
                "Columnas: " + dimensiones.getElemento(1).getData();
    }

}
