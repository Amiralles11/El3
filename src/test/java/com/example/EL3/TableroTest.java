package com.example.EL3;

import com.example.EL3.EstructurasDatos.ListaSimple.ListaSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {
    Tablero tablero = new Tablero(5,6);

    @Test
    void getDimensiones() {
        ListaSimple<Integer> lista = new ListaSimple<>(2);
        lista.add(5);
        lista.add(6);
        assertEquals(lista.getElemento(0).getData(),tablero.getDimensiones().getElemento(0).getData());
        assertEquals(lista.getElemento(1).getData(),tablero.getDimensiones().getElemento(1).getData());
    }

    @Test
    void setDimensiones() {
        ListaSimple<Integer> lista = new ListaSimple<>(2);
        lista.add(10);
        lista.add(9);
        assertDoesNotThrow(()->tablero.setDimensiones(lista));
    }

    @Test
    void getFilas() {
        assertEquals(5,tablero.getFilas());
    }

    @Test
    void getColumnas() {
        assertEquals(6,tablero.getColumnas());
    }

    @Test
    void setFilas() {
        assertDoesNotThrow(()->tablero.setFilas(4));
    }

    @Test
    void setColumnas() {
        assertDoesNotThrow(()->tablero.setColumnas(9));
    }

    @Test
    void testToString() {
        assertEquals(tablero.toString(),"Filas: 5Columnas: 6");
    }
}