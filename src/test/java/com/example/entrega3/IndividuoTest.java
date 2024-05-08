package com.example.entrega3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {
    Individuo individuo = new IndividuoTipoBasico(1,2,3,4);

    @Test
    void getVidas() {
        assertEquals(individuo.getVidas(),1);
    }

    @Test
    void getPorcentajeReproduccion() {
        assertEquals(individuo.getPorcentajeReproduccion(),2);
    }

    @Test
    void getPorcentajeClonacion() {
        assertEquals(individuo.getPorcentajeClonacion(),3);
    }

    @Test
    void getPorcentajeTipoAlReproducirse() {
        assertEquals(individuo.getPorcentajeTipoAlReproducirse(),4);
    }

    @Test
    void setVidas() {
        assertDoesNotThrow(()->individuo.setVidas(10));
    }

    @Test
    void setPorcentajeReproduccion() {
        assertDoesNotThrow(()->individuo.setPorcentajeReproduccion(10));
    }

    @Test
    void setPorcentajeClonacion() {
        assertDoesNotThrow(()->individuo.setPorcentajeClonacion(10));
    }

    @Test
    void setPorcentajeTipoAlReproducirse() {
        assertDoesNotThrow(()->individuo.setPorcentajeTipoAlReproducirse(10));
    }

}