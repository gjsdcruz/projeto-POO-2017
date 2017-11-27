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
public class Convivio {
    protected ArrayList<Pessoa> listaInscritos;
    //protected ArrayList<Local> listaLocaisAVisitar;
    protected double receitaPrevista;
    protected Data data;
    
    public Convivio() {}

    public Convivio(ArrayList<Pessoa> listaInscritos, double receitaPrevista, Data data) {
        this.listaInscritos = listaInscritos;
        this.receitaPrevista = receitaPrevista;
        this.data = data;
    }

    public ArrayList<Pessoa> getListaInscritos() {
        return listaInscritos;
    }

    public void setListaInscritos(ArrayList<Pessoa> listaInscritos) {
        this.listaInscritos = listaInscritos;
    }

    public double getReceitaPrevista() {
        return receitaPrevista;
    }

    public void setReceitaPrevista(double receitaPrevista) {
        this.receitaPrevista = receitaPrevista;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    
    public boolean inscrevePessoa(Pessoa p) {
        for(Pessoa pe : this.getListaInscritos()){
            if(pe.getNome().equalsIgnoreCase(p.getNome())){
                System.out.println("Erro: esta pessoa já se encontra inscrita neste evento");
                return false;
            }
        }
        this.getListaInscritos().add(p);
        return true;
    }
    
    public void listaLocaisAVisitar() {
        System.out.println("===== LOCAIS A VISITAR =====");
        /*
        for(Local l : this.getListaLocaisAVisitar()){
            System.out.println(l);
        }
        */
        System.out.println("============================");
    }
    
    /*
    public double calculaReceita() {
        
    }
    */
}
