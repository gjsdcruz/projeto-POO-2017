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
public class Pessoa implements Serializable {
    protected String nome;
    protected String perfil;
    protected String password;
    protected ArrayList<Local> listaLocaisSelecionados;
    
    public Pessoa() {}

    public Pessoa(String nome, String perfil, String password) {
        this.nome = nome;
        this.perfil = perfil;
        this.password = password;
        this.listaLocaisSelecionados = new ArrayList<Local>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Local> getListaLocaisSelecionados() {
        return listaLocaisSelecionados;
    }

    public void setListaLocaisSelecionados(ArrayList<Local> listaLocaisSelecionados) {
        this.listaLocaisSelecionados = listaLocaisSelecionados;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + "\nPerfil: " + perfil + "\nPassword: " + password;
    }
    
    public boolean adicionaLocal(Local l) {
        if(listaLocaisSelecionados.size() < 5){
            listaLocaisSelecionados.add(l);
            return true;
        }
        else return false;
    }
}
