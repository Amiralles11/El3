package com.example.entrega3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoBibliotecaTest {
    RecursoBiblioteca recursoAgua = new RecursoBiblioteca(1,5,3);
    RecursoBiblioteca recursoAgua2 = new RecursoBiblioteca(recursoAgua);

    @Test
    void getPorcentajeAparicion2() {
        assertEquals(recursoAgua.getPorcentajeAparicion2(),3);
    }

    @Test
    void setPorcentajeAparicion2() {
        assertDoesNotThrow(()->recursoAgua.setPorcentajeAparicion2(20));
    }

    @Test
    void testToString() {
        assertEquals(recursoAgua2.toString(),"RecursoBiblioteca, turnosRestantes = 1");
    }
}