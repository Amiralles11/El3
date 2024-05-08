package com.example.EL3;

import com.example.EL3.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaTest {

    @Test
    void getFilas() {
        Celda celda = new Celda(5,10);
        assertDoesNotThrow(()->celda.getFilas());
        assertEquals(celda.getFilas(),5);
    }

    @Test
    void getColumnas() {
        Celda celda = new Celda(5,10);
        assertDoesNotThrow(()->celda.getColumnas());
        assertEquals(celda.getColumnas(),10);
    }

    @Test
    void testToString() {
        Celda celda = new Celda(5,10);
        assertDoesNotThrow(()->celda.toString());
        assertEquals(celda.toString(),"Celda(6,11){coordenadas=5, 10, individuos=[], recursos=[]}");
        celda.add(new IndividuoTipoBasico(1,2,3,4));
        assertDoesNotThrow(()->celda.toString());
        assertEquals(celda.toString(),"Celda(6,11){coordenadas=5, 10, individuos=[IndividuoBasico 0, vidas= 1], recursos=[]}");
        celda.add(new RecursoAgua(1,2,3));
        assertDoesNotThrow(()->celda.toString());
        assertEquals(celda.toString(),"Celda(6,11){coordenadas=5, 10, individuos=[IndividuoBasico 0, vidas= 1], recursos=[RecursoAgua, turnosRestantes = 1]}");
    }

    @Test
    void add() {
        Celda celda = new Celda(5,10);
        assertDoesNotThrow(()->celda.add(new IndividuoTipoBasico(2,6,9,4)));
    }

    @Test
    void testAdd() {
        Celda celda = new Celda(5,10);
        assertDoesNotThrow(()->celda.add(new RecursoAgua(1,8,3)));
    }

    @Test
    void getIndividuos() {
        Celda celda = new Celda(5,10);
        celda.add(new IndividuoTipoBasico(2,6,9,4));
        assertDoesNotThrow(()->celda.getIndividuos());
        assertEquals(celda.getIndividuos().toString(),"[IndividuoBasico 0, vidas= 2]");

    }

    @Test
    void setIndividuos() {
        Celda celda = new Celda(5,10);
        ListaEnlazada<Individuo> l = new ListaEnlazada<>();
        l.add(new IndividuoTipoBasico(2,6,9,4));
        assertDoesNotThrow(()->celda.setIndividuos(l));
    }

    @Test
    void getRecursos() {
        Celda celda = new Celda(5,10);
        celda.add(new RecursoComida(1,6,3));
        assertDoesNotThrow(()->celda.getRecursos());
        assertEquals(celda.getRecursos().toString(),"[RecursoComida, turnosRestantes = 1]");
    }

    @Test
    void setRecursos() {
        Celda celda = new Celda(5,10);
        ListaEnlazada<Recurso> l = new ListaEnlazada<>();
        l.add(new RecursoMontaña(1,5,3));
        assertDoesNotThrow(()->celda.setRecursos(l));
    }
}