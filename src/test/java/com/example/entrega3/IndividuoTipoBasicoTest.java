package com.example.entrega3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTipoBasicoTest {
    Individuo individuo = new IndividuoTipoBasico(1,2,3,4);
    Individuo individuo2 = new IndividuoTipoBasico(1,individuo);

    @Test
    void testToString() {
        assertEquals(individuo.toString(),"IndividuoBasico 0, vidas= 1");
    }

    @Test
    void move() {
        assertDoesNotThrow(()->individuo2.move());
        assertDoesNotThrow(()->individuo.move());
    }
}