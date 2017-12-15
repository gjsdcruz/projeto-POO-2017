/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.util.ArrayList;

/**
 *
 * @author Bruna
 */
public class AreaDesportiva extends Local {
    private ArrayList<String> desportos;
    
    public AreaDesportiva() {}

    public AreaDesportiva(GPS coordenadas, ArrayList<String> desportos) {
        super(coordenadas);
        this.desportos = desportos;
    }

    public ArrayList<String> getDesportos() {
        return desportos;
    }

    public void setDesportos(ArrayList<String> desportos) {
        this.desportos = desportos;
    }
    
    @Override
    public String isType() {return "AreaDesportiva";}
    
    @Override
    public int getLotacao() {return -1;}
    
    @Override
    public double getConsumoMinimo() {return -1;}
    
    @Override
    public double getCustoIngresso() {return -1;}
    
    @Override
    public Guestlist getGuestlist() {return null;}
    
    @Override
    public String toString() {
        return super.toString() + "\nÁrea Desportiva {Desportos: " + desportos.toString() + '}';
    }
}
