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
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Convivio.
 *
 */
public class Convivio implements Serializable {
    protected ArrayList<Pessoa> listaInscritos;
    protected ArrayList<Local> listaLocaisAVisitar;
    protected double receitaPrevista;
    protected Data data;
    
    /**
    * Construtor por omissão de objetos da classe Convivio
    * 
    */
    public Convivio() {}

    /**
    * Construtor de objetos da classe Convivio
    * 
    * @param listaLocaisAVisitar lista de locais a visitar no Convivio
    * @param data data do Convivio
    */
    public Convivio(ArrayList<Local> listaLocaisAVisitar, Data data) {
        this.listaInscritos = new ArrayList<>();
        this.listaLocaisAVisitar = listaLocaisAVisitar;
        this.receitaPrevista = 0;
        this.data = data;
    }

    /**
    * Método que devolve uma ArrayList de objectos da classe Pessoa que contém as pessoas inscritas neste Convivio
    * 
    *
    * @return lista de pessoas inscritas neste Convivio
    */
    public ArrayList<Pessoa> getListaInscritos() {
        return listaInscritos;
    }

    /**
    * Método que atribui a este Convivio uma ArrayList de objectos da classe Pessoa com as pessoas inscritas
    * 
    * 
    * @param listaInscritos lista de pessoas inscritas a atribuir a este Convivio
    */
    public void setListaInscritos(ArrayList<Pessoa> listaInscritos) {
        this.listaInscritos = listaInscritos;
    }
    
    /**
    * Método que devolve uma ArrayList de objectos da classe Local que contém os locais a visitar neste Convivio
    * 
    *
    * @return lista de locais a visitar neste Convivio
    */
    public ArrayList<Local> getListaLocaisAVisitar() {
        return listaLocaisAVisitar;
    }
    
    /**
    * Método que atribui a este Convivio uma ArrayList de objectos da classe Local com os locais a visitar
    * 
    * 
    * @param listaLocaisAVisitar lista de locais a visitar a atribuir a este Convivio
    */
    public void setListaLocaisAVisitar(ArrayList<Local> listaLocaisAVisitar) {
        this.listaLocaisAVisitar = listaLocaisAVisitar;
    }
    
    /**
    * Método que devolve um double com o valor da receita prevista para este Convivio
    * 
    *
    * @return receita prevista para este Convivio
    */
    public double getReceitaPrevista() {
        return receitaPrevista;
    }

    /**
    * Método que atribui a este Convivio um double com o valor da receita prevista
    * 
    * 
    * @param receitaPrevista receita prevista a atribuir a este Convivio
    */
    public void setReceitaPrevista(double receitaPrevista) {
        this.receitaPrevista = receitaPrevista;
    }

    /**
    * Método que devolve um objecto do tipo Data com a data deste Convivio
    * 
    *
    * @return data deste Convivio
    */
    public Data getData() {
        return data;
    }

    /**
    * Método que atribui a este Convivio um objecto do tipo Data
    * 
    * 
    * @param data data a atribuir a este Convivio
    */
    public void setData(Data data) {
        this.data = data;
    }
    
    /**
    * Método que devolve uma String com todos os dados deste Convivio
    * 
    * 
    * @return lista de pessoas inscritas, lista de locais a visitar, receita prevista e data
    */
    @Override
    public String toString() {
        return "Convívio {\nLista de pessoas inscritas:\n" + listaInscritos + 
                "\nLista de locais a visitar:\n" + listaLocaisAVisitar + "\nReceita prevista: " +
                receitaPrevista + "€\nData: " + data + "\n}";
    }
    
    /**
    * Método que devolve true se a Pessoa passada como parâmetro já estiver inscrita neste Convivio, e false, caso contrário
    * 
    * 
    * @param pessoa pessoa a verificar
    * @return true ou false
    */
    public boolean verificaInscricao(Pessoa pessoa) {
        if(this.getListaInscritos().isEmpty())
            return false;
        
        for(Pessoa inscrito : this.getListaInscritos()) {
            if(inscrito.getNome().equalsIgnoreCase(pessoa.getNome()))
                return true;
        }
        return false;
    }
    
    /**
    * Método que inscreve a Pessoa passada como parâmetro neste Convivio. 
    * 
    * 
    * @param pessoa pessoa a inscrever
    */
    public void inscrevePessoa(Pessoa pessoa) {
        this.getListaInscritos().add(pessoa);
    }
    
    /**
    * Método que devolve uma String com a lista dos locais a visitar neste Convivio. 
    * 
    * 
    * @return lista dos locais a visitar
    */
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
    
    /**
    * Método que devolve uma String com a lista dos locais a visitar neste Convivio, estando essa lista por ordem decrescente do número de inscritos em cada local. 
    * 
    * 
    * @return lista dos locais a visitar
    */
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
    
    /**
    * Método que devolve uma String com a guestlist de cada bar que pertence à listaLocaisAVisitar deste Convivio. 
    * 
    * 
    * @return lista das guestlists dos bares
    */
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
    
    /**
    * Método que calcula a receita prevista para este Convivio. Percorre-se a listaLocaisSelecionados de cada pessoa inscrita neste Convivio
    * 
    * 
    */
    public void calculaReceita() {
        double receita = 0;
        double mod = 1;
        
        for (Pessoa pessoa : this.getListaInscritos()) {
            for (Local local : pessoa.getListaLocaisSelecionados()) {
                // Se for um Bar, acrescenta o seu consumo mínimo
                if(local.isType().equalsIgnoreCase("Bar")) {
                    receita += local.getConsumoMinimo();
                }
                // Se for uma Exposicao, acrescenta o seu custo de ingresso, 
                // aplicando o desconto de 10%, caso a pessoa seja Estudante 
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
