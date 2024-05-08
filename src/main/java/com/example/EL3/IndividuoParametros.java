package com.example.EL3;
import javafx.beans.property.*;

public class IndividuoParametros {
    //Modelo de datos original
    private Individuo original;
    private IntegerProperty vidas = new SimpleIntegerProperty();
    private IntegerProperty porcentajeReproduccion = new SimpleIntegerProperty();
    private IntegerProperty porcentajeClonacion = new SimpleIntegerProperty();
    private IntegerProperty porcentajeTipoAlReproducirse = new SimpleIntegerProperty();

    public IndividuoParametros(Individuo original){
        setOriginal(original);
    }

    public void commit(){
        original.setVidas(vidas.get());
        original.setPorcentajeClonacion(porcentajeClonacion.get());
        original.setPorcentajeReproduccion(porcentajeReproduccion.get());
        original.setPorcentajeTipoAlReproducirse(porcentajeTipoAlReproducirse.get());
    }

    public void rollback(){
        vidas.set(original.getVidas());
        porcentajeClonacion.set(original.getPorcentajeClonacion());
        porcentajeReproduccion.set(original.getPorcentajeReproduccion());
        porcentajeTipoAlReproducirse.set(original.getPorcentajeTipoAlReproducirse());
    }

    public Individuo getOriginal(){
        return original;
    }

    public void setOriginal(Individuo original){
        this.original = original;
        rollback(); //Se inicializan los properties.

    }

    public Property<Number> VidasProperty() {
        return vidas;
    }
    public Property<Number> PorcentajeReproduccionProperty() {
        return porcentajeReproduccion;
    }
    public Property<Number> PorcentajeClonacionProperty() {
        return porcentajeClonacion;
    }
    public Property<Number> PorcentajeTipoAlReproducirse() {
        return porcentajeTipoAlReproducirse;
    }
}
