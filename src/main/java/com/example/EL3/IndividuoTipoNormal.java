package com.example.EL3;

public class IndividuoTipoNormal extends Individuo{
    private int iD;
    public IndividuoTipoNormal(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        super(vidas, porcentajeReproduccion, porcentajeClonacion, porcentajeTipoAlReproducirse);
    }

    @Override
    public String toString() {
        {
            return "IndividuoNormal"+" "+iD+", vidas= "+super.getVidas();
        }
    }

    public IndividuoTipoNormal(int i,Individuo individuo) {
        super(individuo.getVidas(), individuo.getPorcentajeReproduccion(), individuo.getPorcentajeClonacion(), individuo.getPorcentajeTipoAlReproducirse());
        iD = i;
    }

    @Override
    public void move() {

    }

}
