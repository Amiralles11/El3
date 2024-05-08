package com.example.entrega3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoTest {
    Recurso recurso = new RecursoBiblioteca(1,5,3);

    @Test
    void getTiempoAparicion() {
        assertEquals(recurso.getTiempoAparicion(),1);
    }

    @Test
    void getPorcentajeAparicion() {
        assertEquals(recurso.getPorcentajeAparicion(),5);
    }

    @Test
    void setTiempoAparicion() {
        assertDoesNotThrow(()->recurso.setTiempoAparicion(2));
    }

    @Test
    void setPorcentajeAparicion() {
        assertDoesNotThrow(()->recurso.setPorcentajeAparicion(9));
    }

    @Test
    void getPorcentajeAparicion2() {
        assertEquals(recurso.getPorcentajeAparicion2(),3);
    }

    @Test
    void setPorcentajeAparicion2() {
        assertDoesNotThrow(()->recurso.setPorcentajeAparicion(12));
    }
}