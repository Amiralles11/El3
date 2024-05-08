package com.example.EL3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoMontañaTest {
    RecursoMontaña recursoAgua = new RecursoMontaña(1,5,3);
    RecursoMontaña recursoAgua2 = new RecursoMontaña(recursoAgua);

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
        assertEquals(recursoAgua2.toString(),"RecursoMontaña, turnosRestantes = 1");
    }
}