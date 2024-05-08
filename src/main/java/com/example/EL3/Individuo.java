package com.example.EL3;

public abstract class Individuo {
    private int vidas;
    private int porcentajeReproduccion;
    private int porcentajeClonacion;
    private int porcentajeTipoAlReproducirse;

    public Individuo(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        this.vidas = vidas;
        this.porcentajeReproduccion = porcentajeReproduccion;
        this.porcentajeClonacion = porcentajeClonacion;
        this.porcentajeTipoAlReproducirse = porcentajeTipoAlReproducirse;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPorcentajeReproduccion() {
        return porcentajeReproduccion;
    }

    public int getPorcentajeClonacion() {
        return porcentajeClonacion;
    }

    public int getPorcentajeTipoAlReproducirse() {
        return porcentajeTipoAlReproducirse;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void setPorcentajeReproduccion(int porcentajeReproduccion) {
        this.porcentajeReproduccion = porcentajeReproduccion;
    }

    public void setPorcentajeClonacion(int porcentajeClonacion) {
        this.porcentajeClonacion = porcentajeClonacion;
    }

    public void setPorcentajeTipoAlReproducirse(int porcentajeTipoAlReproducirse) {
        this.porcentajeTipoAlReproducirse = porcentajeTipoAlReproducirse;
    }

    public abstract String toString();
    public abstract void move();

}
