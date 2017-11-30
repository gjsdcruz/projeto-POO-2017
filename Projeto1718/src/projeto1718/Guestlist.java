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
public class Guestlist {
    private ArrayList<Pessoa> listaConvidados;
    private int numConvidados;
    
    public Guestlist() {}

    public Guestlist(int numConvidados) {
        this.listaConvidados = new ArrayList<>();
        this.numConvidados = numConvidados;
    }

    public ArrayList<Pessoa> getListaConvidados() {
        return listaConvidados;
    }

    public void setListaConvidados(ArrayList<Pessoa> listaConvidados) {
        this.listaConvidados = listaConvidados;
    }

    public int getNumConvidados() {
        return numConvidados;
    }

    public void setNumConvidados(int numConvidados) {
        this.numConvidados = numConvidados;
    }
    
    public boolean adicionaConvidado(Pessoa p) {
        // FALTA
        return false;
    }
    
    public boolean removeConvidado(Pessoa p) {
        // FALTA
        return false;
    }
    
    public boolean verificaPerfil(Pessoa p) {
        // FALTA
        return false;
    }
}
