/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;

/**
 *
 * @author Bruna
 */
public abstract class Local implements Serializable, Comparable {
    protected GPS coordenadas;
    protected int numInscritos;
    
    public Local() {}

    public Local(GPS coordenadas) {
        this.coordenadas = coordenadas;
        this.numInscritos = 0;
    }

    public GPS getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(GPS coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getNumInscritos() {
        return numInscritos;
    }

    public void setNumInscritos(int numInscritos) {
        this.numInscritos = numInscritos;
    }
    
    public abstract String isType();
    
    public abstract int getLotacao();
    
    public abstract double getConsumoMinimo();
    
    public abstract double getCustoIngresso();
    
    public abstract Guestlist getGuestlist();

    @Override
    public String toString() {
        return "Local { " + coordenadas + " }";
    }

    @Override
    public int compareTo(Object o) {
        int localNumInscritos = ((Local)o).getNumInscritos();

        return localNumInscritos - this.getNumInscritos();
    }
}
