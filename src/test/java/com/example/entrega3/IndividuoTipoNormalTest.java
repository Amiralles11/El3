package com.example.entrega3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTipoNormalTest {
    Individuo individuo = new IndividuoTipoNormal(1,2,3,4);
    Individuo individuo2 = new IndividuoTipoNormal(1,individuo);

    @Test
    void testToString() {
        assertEquals(individuo.toString(),"IndividuoNormal 0, vidas= 1");
    }

    @Test
    void move() {
        assertDoesNotThrow(()->individuo2.move());
        assertDoesNotThrow(()->individuo.move());
    }
}