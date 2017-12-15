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
            System.out.println("Erro! Guestlist cheia.");
            return false;
        }
    }
    
    public boolean removeConvidado(Pessoa p) {
        if(this.getListaConvidados().remove(p)) {
            return true;
        } 
        else return false;
    }
    
    public void listaConvidados() {
        System.out.println("=============== GUESTLIST ===============");
        for(Pessoa convidado : this.getListaConvidados()) {
            if(convidado.isType().equalsIgnoreCase("Estudante")) {
                System.out.println("Nome: " + convidado.getNome());
                System.out.println("Perfil: " + convidado.getPerfil());
                System.out.println("Curso: " + convidado.getCurso() + '\n');
            }
            else {
                System.out.println("Nome: " + convidado.getNome());
                System.out.println("Perfil: " + convidado.getPerfil() + '\n');
            }
        }
    }
}
