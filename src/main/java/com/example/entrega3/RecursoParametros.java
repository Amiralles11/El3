package com.example.entrega3;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;

public class RecursoParametros {
    //Modelo de datos original
    protected Recurso original;
    private IntegerProperty tiempoAparicion = new SimpleIntegerProperty();
    private IntegerProperty porcentajeAparicion = new SimpleIntegerProperty();

    public RecursoParametros(Recurso original){
        setOriginal(original);
    }

    public void commit(){
        original.setTiempoAparicion(tiempoAparicion.get());
        original.setPorcentajeAparicion(porcentajeAparicion.get());
    }

    public void rollback(){
        tiempoAparicion.set(original.getTiempoAparicion());
        porcentajeAparicion.set(original.getPorcentajeAparicion());;
    }

    public Recurso getOriginal(){
        return original;
    }

    public void setOriginal(Recurso original){
        this.original = original;
        rollback(); //Se inicializan los properties.

    }

    public Property<Number> TiempoAparicionProperty() {
        return tiempoAparicion;
    }
    public Property<Number> PorcentajeAparicionProperty() {
        return porcentajeAparicion;
    }


    public static class RecursoParametrosAgua{
        protected RecursoAgua original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();

        public RecursoParametrosAgua(RecursoAgua original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());
        }

        public Recurso getOriginal(){
            return original;
        }

        public void setOriginal(RecursoAgua original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }

    }
    public static class RecursoParametrosPozo{
        protected RecursoPozo original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();

        public RecursoParametrosPozo(RecursoPozo original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());;
        }

        public Recurso getOriginal(){
            return original;
        }

        public void setOriginal(RecursoPozo original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
    }
    public static class RecursoParametrosComida{
        protected RecursoComida original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();

        public RecursoParametrosComida(RecursoComida original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());;
        }

        public Recurso getOriginal(){
            return original;
        }

        public void setOriginal(RecursoComida original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
    }
    public static class RecursoParametrosBiblioteca{
        protected RecursoBiblioteca original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();

        public RecursoParametrosBiblioteca(RecursoBiblioteca original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());;
        }

        public Recurso getOriginal(){
            return original;
        }

        public void setOriginal(RecursoBiblioteca original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
    }
    public static class RecursoParametrosMontaña{
        protected RecursoMontaña original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();

        public RecursoParametrosMontaña(RecursoMontaña original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());;
        }

        public Recurso getOriginal(){
            return original;
        }

        public void setOriginal(RecursoMontaña original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
    }
    public static class RecursoParametrosTesoro{
        protected RecursoTesoro original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();

        public RecursoParametrosTesoro(RecursoTesoro original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());;
        }

        public Recurso getOriginal(){
            return original;
        }

        public void setOriginal(RecursoTesoro original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
    }
}
