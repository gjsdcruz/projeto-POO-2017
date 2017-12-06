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
public abstract class Local implements Serializable {
    protected GPS coordenadas;
    
    public Local() {}

    public Local(GPS coordenadas) {
        this.coordenadas = coordenadas;
    }

    public GPS getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(GPS coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public abstract int getLotacao();
    
    public abstract boolean isAreaDesportiva();
    
    public abstract boolean isBar();
    
    public abstract boolean isExposicao();
    
    public abstract boolean isJardim();

    @Override
    public String toString() {
        return "Local {" + coordenadas + '}';
    }
}
