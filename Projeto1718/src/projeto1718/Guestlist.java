/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Bruna
 */
public class Guestlist implements Serializable {
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
        if (this.getListaConvidados().size() < this.getNumConvidados()) {
            this.getListaConvidados().add(p);
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean removeConvidado(Pessoa p) {
        if(this.getListaConvidados().remove(p)) {
            return true;
        } 
        else return false;
    }
    
    public String listaConvidados() {
        String s = "=============== GUESTLIST ===============\n";
        
        if(this.getListaConvidados().isEmpty()) {
            s = s.concat("Guestlist vazia\n");
            return s;
        }
        
        for(Pessoa convidado : this.getListaConvidados()) {
            if(convidado.isType().equalsIgnoreCase("Estudante")) {
                s = s.concat("Nome: " + convidado.getNome() + "\n");
                s = s.concat("Perfil: " + convidado.getPerfil() + "\n");
                s = s.concat("Curso: " + convidado.getCurso() + "\n\n");
            }
            else {
                s = s.concat("Nome: " + convidado.getNome() + "\n");
                s = s.concat("Perfil: " + convidado.getPerfil() + "\n\n");
            }
        }
        return s;
    }
}
