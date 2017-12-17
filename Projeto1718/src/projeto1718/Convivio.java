/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Bruna
 */
public class Convivio implements Serializable {
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
    
    @Override
    public String toString() {
        return "Convívio {\nLista de pessoas inscritas:\n" + listaInscritos + 
                "\nLista de locais a visitar:\n" + listaLocaisAVisitar + "\nReceita prevista: " +
                receitaPrevista + "€\nData: " + data + "\n}";
    }
    
    public boolean verificaInscricao(Pessoa pessoa) {
        if(this.getListaInscritos().isEmpty())
            return false;
        
        for(Pessoa inscrito : this.getListaInscritos()) {
            if(inscrito.getNome().equalsIgnoreCase(pessoa.getNome()))
                return true;
        }
        return false;
    }
    
    public void inscrevePessoa(Pessoa pessoa) {
        this.getListaInscritos().add(pessoa);
    }
    
    public String apresentaLocaisAVisitar() {
        String s = "\n================ LOCAIS A VISITAR ================\n";
        int i = 1;
        for(Local local : this.getListaLocaisAVisitar()) {
            s = s.concat(String.valueOf(i) + " - " + local.toString() + "\n");
            s = s.concat("Inscritos: " + String.valueOf(local.getNumInscritos()) + "\n\n");
            i++;
        }
        
        return s;
    }
    
    public String seriacaoLocaisAVisitar() {
        ArrayList<Local> listaOrdenada = (ArrayList<Local>) this.getListaLocaisAVisitar().clone();
        Collections.sort(listaOrdenada);
        
        String s = "\n================ LOCAIS A VISITAR ================\n";
        for(Local local : listaOrdenada) {
            s = s.concat(local.toString() + "\n");
            s = s.concat("Inscritos: " + String.valueOf(local.getNumInscritos()) + "\n\n");
        }
        return s;
    }
    
    public String visualizaGuestlists() {
        String s = "\n";
        for(Local local : this.getListaLocaisAVisitar()) {
            if(local.isType().equalsIgnoreCase("Bar")) {
                s = s.concat(local.toString() + "\n");
                s = s.concat(local.getGuestlist().listaConvidados() + "\n");
            }
        }
        return s;
    }
    
    public void calculaReceita() {
        double receita = 0;
        double mod = 1;
        
        for (Pessoa pessoa : this.getListaInscritos()) {
            for (Local local : pessoa.getListaLocaisSelecionados()) {
                if(local.isType().equalsIgnoreCase("Bar")) {
                    receita += local.getConsumoMinimo();
                }
                else if(local.isType().equalsIgnoreCase("Exposicao")) {
                    if(pessoa.isDesconto()) 
                        mod = 0.9;
                    else
                        mod = 1;
                    receita += (local.getCustoIngresso() * mod);
                }
            }
        }
        this.setReceitaPrevista(receita);
    }
}
