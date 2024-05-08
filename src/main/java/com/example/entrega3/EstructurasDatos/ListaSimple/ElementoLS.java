package com.example.entrega3.EstructurasDatos.ListaSimple;

public class ElementoLS<T> {
    private T data;
    public ElementoLS(T o){
        this.data = o;
    }
    public ElementoLS(){

    }
    public T getData(){
        return data;
    }
    public void setData(T newData){
        this.data = newData;
    }
}
