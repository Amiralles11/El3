package com.example.entrega3;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;

public class TableroParametros {
    protected Tablero original;
    private IntegerProperty filas = new SimpleIntegerProperty();
    private IntegerProperty columnas = new SimpleIntegerProperty();

    public TableroParametros(Tablero original){
        setOriginal(original);
    }

    public void commit(){
        original.setFilas(filas.get());
        original.setColumnas(columnas.get());
    }

    public void rollback(){
        filas.set(original.getFilas());
        columnas.set(original.getColumnas());
    }

    public Tablero getOriginal(){
        return original;
    }

    public void setOriginal(Tablero original){
        this.original = original;
        rollback(); //Se inicializan los properties.

    }

    public Property<Number> FilasProperty() {
        return filas;
    }
    public Property<Number> ColumnasProperty() {
        return columnas;
    }
}
