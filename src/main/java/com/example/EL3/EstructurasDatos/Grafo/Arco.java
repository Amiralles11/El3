package com.example.EL3.EstructurasDatos.Grafo;

public class Arco<TipoDato> {
    private Vertice<TipoDato> v1;
    private Vertice<TipoDato> v2;
    private Double dato;
    private String etiqueta;

    public Arco(Vertice<TipoDato> v1, Vertice<TipoDato> v2, Double dato, String etiqueta) {
        this.v1 = v1;
        this.v2 = v2;
        this.dato = dato;
        this.etiqueta = etiqueta;
    }
    public Vertice<TipoDato> getV1() {
        return v1;
    }

    public Vertice<TipoDato> getV2() {
        return v2;
    }

    public Double getDato() {
        return dato;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setV1(Vertice<TipoDato> v1) {
        this.v1 = v1;
    }

    public void setV2(Vertice<TipoDato> v2) {
        this.v2 = v2;
    }

    public void setDato(Double dato) {
        this.dato = dato;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    public Vertice<TipoDato> getOtroVertice(TipoDato dato) throws ElementoInexistenteExcepcion{
        if (!dato.equals(this.getV1().getDato()) && !dato.equals(this.getV2().getDato())) {
            throw new ElementoInexistenteExcepcion("Error, el vértice no pertenece al arco");
        } else {
            if (dato != this.getV1().getDato()) {
                return this.getV1();
            } else {
                return this.getV2();
            }
        }
    }
}
