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
    protected ArrayList<Local> listaLocaisAVisitar;
    protected double receitaPrevista;
    protected Data data;
    
    public Convivio() {}

    public Convivio(ArrayList<Local> listaLocaisAVisitar, Data data) {
        this.listaInscritos = new ArrayList<>();
        this.listaLocaisAVisitar = listaLocaisAVisitar;
        this.receitaPrevista = 0;
        this.data = data;
    }

    public ArrayList<Pessoa> getListaInscritos() {
        return listaInscritos;
    }

    public void setListaInscritos(ArrayList<Pessoa> listaInscritos) {
        this.listaInscritos = listaInscritos;
    }
    
    public ArrayList<Local> getListaLocaisAVisitar() {
        return listaLocaisAVisitar;
    }
    
    public void setListaLocaisAVisitar(ArrayList<Local> listaLocaisAVisitar) {
        this.listaLocaisAVisitar = listaLocaisAVisitar;
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
                System.out.println("Erro: esta pessoa já se encontra inscrita neste convívio");
                return false;
            }
        }
        this.getListaInscritos().add(p);
        return true;
    }
    
    public void listaLocaisAVisitar() {
        System.out.println("===== LOCAIS A VISITAR =====");
        for(Local l : this.getListaLocaisAVisitar()){
            System.out.println(l);
        }
        System.out.println("============================");
    }
    
    /*
    public double calculaReceitaTotal() {
        // FALTA
    }
    */
}
