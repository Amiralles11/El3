package com.example.entrega3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class IndividuoTipoAvanzadoTest {
    Individuo individuo = new IndividuoTipoAvanzado(1,2,3,4);
    Individuo individuo2 = new IndividuoTipoAvanzado(1,individuo);
    @Test
    void testToString() {
        assertEquals(individuo.toString(),"IndividuoAvanzado 0, vidas= 1");
    }

    @Test
    void move() {
        assertDoesNotThrow(()->individuo2.move());
    }
}