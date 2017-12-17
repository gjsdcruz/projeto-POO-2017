/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Guestlist.
 *
 */
public class Guestlist implements Serializable {
    private ArrayList<Pessoa> listaConvidados;
    private int numConvidados;
    
    /**
    * Construtor por omissão de objetos da classe Guestlist
    * 
    */
    public Guestlist() {}

    /**
    * Construtor de objetos da classe Guestlist
    * 
    * @param numConvidados número de convidados da Guestlist
    */
    public Guestlist(int numConvidados) {
        this.listaConvidados = new ArrayList<>();
        this.numConvidados = numConvidados;
    }

    /**
    * Método que devolve uma ArrayList de objectos da classe Pessoa que contém os convidados desta Guestlist
    * 
    *
    * @return lista de convidados desta Guestlist
    */
    public ArrayList<Pessoa> getListaConvidados() {
        return listaConvidados;
    }

    /**
    * Método que atribui a esta Guestlist uma ArrayList de objectos da classe Pessoa com os convidados
    * 
    * 
    * @param listaConvidados lista de convidados a atribuir a esta Guestlist
    */
    public void setListaConvidados(ArrayList<Pessoa> listaConvidados) {
        this.listaConvidados = listaConvidados;
    }

    /**
    * Método que devolve um int com o valor do número de convidados desta Guestlist
    * 
    *
    * @return número de convidados desta Guestlist
    */
    public int getNumConvidados() {
        return numConvidados;
    }

    /**
    * Método que atribui a esta Guestlist um int com o valor do número de convidados
    * 
    * 
    * @param numConvidados número de convidados a atribuir a esta Guestlist
    */
    public void setNumConvidados(int numConvidados) {
        this.numConvidados = numConvidados;
    }
    
    /**
    * Método que devolve um boolean com o resultado da adição da Pessoa passada como parâmetro à listaConvidados desta Guestlist. 
    * 
    * 
    * @param p pessoa a adicionar
    * @return resultado da operação (true, se ainda houver espaço nesta Guestlist, false, caso contrário)
    */
    public boolean adicionaConvidado(Pessoa p) {
        if (this.getListaConvidados().size() < this.getNumConvidados()) {
            this.getListaConvidados().add(p);
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
    * Método para remover a Pessoa passada como parâmetro da listaConvidados desta Guestlist. 
    * 
    * 
    * @param p pessoa a remover
    * @return resultado da operação (true, se for removida com sucesso, false, caso contrário)
    */
    public boolean removeConvidado(Pessoa p) {
        if(this.getListaConvidados().remove(p)) {
            return true;
        } 
        else return false;
    }
    
    /**
    * Método que devolve uma String com a lista dos convidados desta Guestlist. 
    * 
    * 
    * @return lista dos convidados (caso exista)
    */
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
