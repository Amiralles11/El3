package com.example.entrega3;

import com.example.entrega3.EstructurasDatos.ListaSimple.ListaSimple;

import java.util.Random;

public class PrincipalController {
    private ListaSimple<ListaSimple<Celda>> listaCeldas;
    private IndividuoTipoBasico individuoTipoBasico;
    private IndividuoTipoNormal individuoTipoNormal;
    private IndividuoTipoAvanzado individuoTipoAvanzado;
    private RecursoAgua recursoAgua;
    private RecursoBiblioteca recursoBiblioteca;
    private RecursoComida recursoComida;
    private RecursoMontaña recursoMontaña;
    private RecursoPozo recursoPozo;
    private RecursoTesoro recursoTesoro;

    public PrincipalController(IndividuoTipoBasico individuoTipoBasico,
                      IndividuoTipoNormal individuoTipoNormal, IndividuoTipoAvanzado individuoTipoAvanzado,
                      RecursoAgua recursoAgua, RecursoComida recursoComida, RecursoMontaña recursoMontaña,
                      RecursoTesoro recursoTesoro, RecursoBiblioteca recursoBiblioteca, RecursoPozo recursoPozo,
                      ListaSimple<ListaSimple<Celda>> lista){
        this.individuoTipoBasico = individuoTipoBasico;
        this.individuoTipoNormal = individuoTipoNormal;
        this.individuoTipoAvanzado = individuoTipoAvanzado;
        this.recursoAgua = recursoAgua;
        this.recursoBiblioteca = recursoBiblioteca;
        this.recursoComida = recursoComida;
        this.recursoMontaña = recursoMontaña;
        this.recursoPozo = recursoPozo;
        this.recursoTesoro = recursoTesoro;
        this.listaCeldas = lista;
    }

    public ListaSimple<ListaSimple<Celda>> getListaCeldas() {
        return listaCeldas;
    }

    public void setListaCeldas(ListaSimple<ListaSimple<Celda>> listaCeldas) {
        this.listaCeldas = listaCeldas;
    }

    public IndividuoTipoBasico getIndividuoTipoBasico() {
        return individuoTipoBasico;
    }

    public void setIndividuoTipoBasico(IndividuoTipoBasico individuoTipoBasico) {
        this.individuoTipoBasico = individuoTipoBasico;
    }

    public IndividuoTipoNormal getIndividuoTipoNormal() {
        return individuoTipoNormal;
    }

    public void setIndividuoTipoNormal(IndividuoTipoNormal individuoTipoNormal) {
        this.individuoTipoNormal = individuoTipoNormal;
    }

    public IndividuoTipoAvanzado getIndividuoTipoAvanzado() {
        return individuoTipoAvanzado;
    }

    public void setIndividuoTipoAvanzado(IndividuoTipoAvanzado individuoTipoAvanzado) {
        this.individuoTipoAvanzado = individuoTipoAvanzado;
    }

    public RecursoAgua getRecursoAgua() {
        return recursoAgua;
    }

    public void setRecursoAgua(RecursoAgua recursoAgua) {
        this.recursoAgua = recursoAgua;
    }

    public RecursoBiblioteca getRecursoBiblioteca() {
        return recursoBiblioteca;
    }

    public void setRecursoBiblioteca(RecursoBiblioteca recursoBiblioteca) {
        this.recursoBiblioteca = recursoBiblioteca;
    }

    public RecursoComida getRecursoComida() {
        return recursoComida;
    }

    public void setRecursoComida(RecursoComida recursoComida) {
        this.recursoComida = recursoComida;
    }

    public RecursoMontaña getRecursoMontaña() {
        return recursoMontaña;
    }

    public void setRecursoMontaña(RecursoMontaña recursoMontaña) {
        this.recursoMontaña = recursoMontaña;
    }

    public RecursoPozo getRecursoPozo() {
        return recursoPozo;
    }

    public void setRecursoPozo(RecursoPozo recursoPozo) {
        this.recursoPozo = recursoPozo;
    }

    public RecursoTesoro getRecursoTesoro() {
        return recursoTesoro;
    }

    public void setRecursoTesoro(RecursoTesoro recursoTesoro) {
        this.recursoTesoro = recursoTesoro;
    }

    public void bucleControl() {

    }

    private void vidaActualicer() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                for (int k = 0; this.getListaCeldas().getElemento(i).getData().getElemento(j).getData().getIndividuos().getNumeroElementos() != k; k++) {
                    Individuo actual = listaCeldas.getElemento(i).getData().getElemento(j).getData().getIndividuos().getElemento(k).getData();
                    actual.setVidas(actual.getVidas() - 1);
                    actual.setPorcentajeReproduccion(actual.getPorcentajeReproduccion() - 10);
                    actual.setPorcentajeClonacion(actual.getPorcentajeClonacion() - 10);
                    if (actual.getVidas() == 0) {
                        Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                        celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(actual));
                    } else if (actual.getPorcentajeClonacion() <= 0) {
                        actual.setPorcentajeClonacion(0);
                    }
                    if (actual.getPorcentajeReproduccion() <= 0) {
                        actual.setPorcentajeReproduccion(0);
                    }
                }
            }
        }
    }

    private void tiempoRecursoActualicer() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                for (int k = 0; this.getListaCeldas().getElemento(i).getData().getElemento(j).getData().getRecursos().getNumeroElementos() != k; k++) {
                    Recurso actual = listaCeldas.getElemento(i).getData().getElemento(j).getData().getRecursos().getElemento(k).getData();
                    actual.setTiempoAparicion(actual.getTiempoAparicion() - 1);
                    if (actual.getTiempoAparicion() == 0) {
                        Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                        celdaActual.getIndividuos().del(celdaActual.getRecursos().getPosicion(actual));
                    }
                }
            }
        }
    }

    private void interaccionRecursos() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                for (int k = 0; celdaActual.getRecursos().getNumeroElementos() != k; k++) {
                    Recurso recursoActual = celdaActual.getRecursos().getElemento(k).getData();
                    if (recursoActual instanceof RecursoPozo) {
                        celdaActual.getIndividuos().vaciar();
                    } else if (recursoActual instanceof RecursoAgua) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setVidas(actual.getVidas() + 2);
                        }
                    } else if (recursoActual instanceof RecursoComida) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setVidas(actual.getVidas() + 10);
                        }
                    } else if (recursoActual instanceof RecursoBiblioteca) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setPorcentajeClonacion(actual.getPorcentajeClonacion() + 50);
                        }
                    } else if (recursoActual instanceof RecursoMontaña) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setVidas(actual.getVidas() - 2);
                            if (actual.getVidas() <= 0) {
                                celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(actual));
                            }
                        }
                    } else if (recursoActual instanceof RecursoTesoro) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setPorcentajeReproduccion(actual.getPorcentajeReproduccion() + 50);
                        }
                    }
                }
            }
        }
    }

    private void reproduccionClonacion() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                if (celdaActual.getIndividuos().getNumeroElementos() > 1) {
                    reproducir(celdaActual);
                }

            }
        }
    }
    private void reproducir(Celda celdaActual) {
        Random r = new Random();
        int valor1 = r.nextInt(0, 2);
        int valor2 = r.nextInt(0, 2);
        if (valor1 != valor2 && celdaActual.getIndividuos().getElemento(valor1) != null && celdaActual.getIndividuos().getElemento(valor2) != null) {
            Random r1 = new Random();
            int prob1 = r1.nextInt(1, 100);
            if (celdaActual.getIndividuos().getElemento(valor1).getData().getPorcentajeReproduccion() >= prob1) {
                Random r2 = new Random();
                int prob2 = r2.nextInt(1, 100);
                if (celdaActual.getIndividuos().getElemento(valor2).getData().getPorcentajeReproduccion() >= prob2) {
                    Individuo padre1 = celdaActual.getIndividuos().getElemento(valor1).getData();
                    Individuo padre2 = celdaActual.getIndividuos().getElemento(valor2).getData();
                    if (padre1 instanceof IndividuoTipoBasico && padre2 instanceof IndividuoTipoBasico) {
                        IndividuoTipoBasico hijo = new IndividuoTipoBasico(individuoTipoBasico.getVidas(), individuoTipoBasico.getPorcentajeReproduccion(),individuoTipoBasico.getPorcentajeClonacion(), individuoTipoBasico.getPorcentajeTipoAlReproducirse());
                        celdaActual.getIndividuos().add(hijo);
                    } else if (padre1 instanceof IndividuoTipoNormal && padre2 instanceof IndividuoTipoNormal) {
                        IndividuoTipoNormal hijo = new IndividuoTipoNormal(individuoTipoNormal.getVidas(), individuoTipoNormal.getPorcentajeReproduccion(),individuoTipoNormal.getPorcentajeClonacion(), individuoTipoNormal.getPorcentajeTipoAlReproducirse());
                        celdaActual.getIndividuos().add(hijo);
                    } else if (padre1 instanceof IndividuoTipoAvanzado && padre2 instanceof IndividuoTipoAvanzado) {
                        IndividuoTipoAvanzado hijo = new IndividuoTipoAvanzado(individuoTipoAvanzado.getVidas(), individuoTipoAvanzado.getPorcentajeReproduccion(),individuoTipoAvanzado.getPorcentajeClonacion(), individuoTipoAvanzado.getPorcentajeTipoAlReproducirse());
                        celdaActual.getIndividuos().add(hijo);
                    } else if ((padre1 instanceof IndividuoTipoBasico && padre2 instanceof IndividuoTipoNormal) || (padre1 instanceof IndividuoTipoNormal && padre2 instanceof IndividuoTipoBasico)) {
                        Random r3 = new Random();
                        int prob3 = r3.nextInt(1, 100);
                        if (padre1.getPorcentajeTipoAlReproducirse() >= prob3) {
                            IndividuoTipoNormal hijo = new IndividuoTipoNormal(individuoTipoNormal.getVidas(), individuoTipoNormal.getPorcentajeReproduccion(),individuoTipoNormal.getPorcentajeClonacion(), individuoTipoNormal.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        } else {
                            IndividuoTipoBasico hijo = new IndividuoTipoBasico(individuoTipoBasico.getVidas(), individuoTipoBasico.getPorcentajeReproduccion(),individuoTipoBasico.getPorcentajeClonacion(), individuoTipoBasico.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        }
                    } else if ((padre1 instanceof IndividuoTipoBasico && padre2 instanceof IndividuoTipoAvanzado) || (padre1 instanceof IndividuoTipoAvanzado && padre2 instanceof IndividuoTipoBasico)) {
                        Random r3 = new Random();
                        int prob3 = r3.nextInt(1, 100);
                        if (padre1.getPorcentajeTipoAlReproducirse() >= prob3) {
                            IndividuoTipoAvanzado hijo = new IndividuoTipoAvanzado(individuoTipoAvanzado.getVidas(), individuoTipoAvanzado.getPorcentajeReproduccion(),individuoTipoAvanzado.getPorcentajeClonacion(), individuoTipoAvanzado.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        } else {
                            IndividuoTipoBasico hijo = new IndividuoTipoBasico(individuoTipoBasico.getVidas(), individuoTipoBasico.getPorcentajeReproduccion(),individuoTipoBasico.getPorcentajeClonacion(), individuoTipoBasico.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        }
                    } else if ((padre1 instanceof IndividuoTipoNormal && padre2 instanceof IndividuoTipoAvanzado) || (padre1 instanceof IndividuoTipoAvanzado && padre2 instanceof IndividuoTipoNormal)) {
                        Random r3 = new Random();
                        int prob3 = r3.nextInt(1, 100);
                        if (padre1.getPorcentajeTipoAlReproducirse() >= prob3) {
                            IndividuoTipoAvanzado hijo = new IndividuoTipoAvanzado(individuoTipoAvanzado.getVidas(), individuoTipoAvanzado.getPorcentajeReproduccion(),individuoTipoAvanzado.getPorcentajeClonacion(), individuoTipoAvanzado.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        } else {
                            IndividuoTipoNormal hijo = new IndividuoTipoNormal(individuoTipoNormal.getVidas(), individuoTipoNormal.getPorcentajeReproduccion(),individuoTipoNormal.getPorcentajeClonacion(), individuoTipoNormal.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        }
                    }
                }
            }

        } else {
            reproducir(celdaActual);
        }
    }

    private void hacerEspacio() {

    }
}
