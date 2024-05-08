package com.example.EL3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoTesoroTest {
    RecursoTesoro recursoAgua = new RecursoTesoro(1,5,3);
    RecursoTesoro recursoAgua2 = new RecursoTesoro(recursoAgua);

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
        assertEquals(recursoAgua2.toString(),"RecursoTesoro, turnosRestantes = 1");
    }
}