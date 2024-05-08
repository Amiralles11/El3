package com.example.EL3.EstructurasDatos.ListaSimple;

public class ListaSimple<T> {
    private ElementoLS<T>[] datos;
    private final int maximo;

    public ListaSimple(int maximo) {
        this.maximo = maximo;
        this.datos = new ElementoLS[maximo];
    }

    public boolean isVacia() {
        for (int i = 0; i < maximo; i++) {
            if (datos[i] != null) {
                return false;
            }
        }
        return true;
    }

    public void vaciar() {
        for (int i = 0; i < maximo; i++) {
            this.datos[i] = null;
        }
    }

    protected int add(ElementoLS<T> el) {
        int i = 0;
        while (datos[i] != null) {
            i++;
        }
        if (i < maximo) {
            datos[i] = el;
        }
        return getNumeroElementos();
    }

    public void add(T o) {
        ElementoLS<T> ele = new ElementoLS<>(o);
        add(ele);
    }

    public void insert(T s, int posicion) {
        ElementoLS<T> e = new ElementoLS<>(s);
        Integer i = 0;
        if (datos[posicion] == null) {
            datos[posicion] = e;
        } else {
            if (datos[maximo - 1] == null) {
                for (int j = 0; j < getNumeroElementos(); j++) {
                    datos[getPosicion(getUltimo().getData()) - j] = datos[getPosicion(getUltimo().getData()) + 1 + j];
                }
            }
            datos[posicion] = e;
        }
    }

    public int del(int posicion) {
        ElementoLS<T> e = new ElementoLS<>();
        for (int i = 0; posicion + i + 1 < maximo; i++) {
            if (datos[posicion] != null) {
                datos[posicion + i] = datos[posicion + i + 1];
            } else {
                return 0;
            }
        }
        return 0;
    }

    public Integer getPosicion(T el) {
        for (int i = 0; i < maximo; i++) {
            if (datos[i].getData() == el) {
                return i;
            }
        }
        return null;
    }

    public ElementoLS<T> getPrimero() {
        return datos[0];
    }

    public ElementoLS<T> getSiguiente(T el) {
        ElementoLS<T> e = new ElementoLS<>(el);
        int i = 0;
        while (i < maximo - 1) {
            if (datos[i].getData() == e.getData()) {
                return datos[i + 1];
            }
            i++;
        }
        return null;
    }

    public ElementoLS<T> getElemento(int posicion) {
        if (datos[posicion] != null) {
            return datos[posicion];
        }
        return null;
    }
    public int getNumeroElementos() {
        int num = 0;
        for (int i = 0; i < maximo; i++) {
            if (datos[i] != null) {
                num++;
            }
        }
        return num;
    }
    public ElementoLS<T> getUltimo() {return datos[getNumeroElementos() - 1];}

    @Override
    public String toString() {
        if(isVacia()){
            return "";
        }
        String s = "";
        for(int i =0;i<getNumeroElementos();i++) {
            if(i<getNumeroElementos()-1){
                s +=getElemento(i).getData() + ", ";
            }
            else if(i==getNumeroElementos()-1){
                s +=getElemento(i).getData();
            }
        }
        return s;

    }
}