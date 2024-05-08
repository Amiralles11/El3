package com.example.entrega3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoPozoTest {
    RecursoPozo recursoAgua = new RecursoPozo(1,5,3);
    RecursoPozo recursoAgua2 = new RecursoPozo(recursoAgua);

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
        assertEquals(recursoAgua2.toString(),"RecursoPozo, turnosRestantes = 1");
    }
}