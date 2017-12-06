/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Bruna
 */
public class Convivio implements Serializable {
    protected ArrayList<Pessoa> listaInscritos;
    protected ArrayList<Local> listaLocaisAVisitar;
    protected double receitaPrevista;
    protected Data data;
    protected HashMap<Integer,Integer> mapaInscritos;
    
    public Convivio() {}

    public Convivio(ArrayList<Local> listaLocaisAVisitar, Data data) {
        this.listaInscritos = new ArrayList<>();
        this.listaLocaisAVisitar = listaLocaisAVisitar;
        this.receitaPrevista = 0;
        this.data = data;
        this.mapaInscritos = new HashMap<>(this.listaLocaisAVisitar.size());
        
        for(int i=0; i<this.listaLocaisAVisitar.size(); i++){
            mapaInscritos.put(i, 0);
        }
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

    public HashMap<Integer, Integer> getMapaInscritos() {
        return mapaInscritos;
    }

    public void setMapaInscritos(HashMap<Integer, Integer> mapaInscritos) {
        this.mapaInscritos = mapaInscritos;
    }

    @Override
    public String toString() {
        return "Convívio {\nLista de pessoas inscritas:\n" + listaInscritos + 
                "\nLista de locais a visitar:\n" + listaLocaisAVisitar + "\nReceita prevista: " +
                receitaPrevista + "€\nData: " + data + "\n}";
    }
}
