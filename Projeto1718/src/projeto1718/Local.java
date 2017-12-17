/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Local.
 *
 */
public abstract class Local implements Serializable, Comparable {
    protected GPS coordenadas;
    protected int numInscritos;
    
    /**
    * Construtor por omissão de objetos da classe Local
    * 
    */
    public Local() {}

    /**
    * Construtor de objetos da classe Local
    * 
    * @param coordenadas coordenadas do Local
    */
    public Local(GPS coordenadas) {
        this.coordenadas = coordenadas;
        this.numInscritos = 0;
    }

    /**
    * Método que devolve um objecto do tipo GPS que inclui as coordenadas deste Local
    * 
    *
    * @return coordenadas deste Local
    */
    public GPS getCoordenadas() {
        return coordenadas;
    }

    /**
    * Método que atribui a este Local um objecto do tipo GPS que inclui as coordenadas
    * 
    * 
    * @param coordenadas coordenadas a atribuir a este Local
    */
    public void setCoordenadas(GPS coordenadas) {
        this.coordenadas = coordenadas;
    }

    /**
    * Método que devolve um int com o número de pessoas inscritas para visitar este Local
    * 
    *
    * @return número de inscritos deste Local
    */
    public int getNumInscritos() {
        return numInscritos;
    }

    /**
    * Método que atribui a este Local um int com o número de pessoas inscritas para visitar
    * 
    * 
    * @param numInscritos número de inscritos a atribuir a este Local
    */
    public void setNumInscritos(int numInscritos) {
        this.numInscritos = numInscritos;
    }
    
    /**
    * Método (abstrato) que devolve uma String com o tipo de local
    * 
    * @return 
    */
    public abstract String isType();
    
    /**
    * Método (abstrato) que devolve um int com o valor da lotação deste local
    * 
    * @return 
    */
    public abstract int getLotacao();
    
    /**
    * Método (abstrato) que devolve um double com o valor do consumo mínimo deste local
    * 
    * @return 
    */
    public abstract double getConsumoMinimo();
    
    /**
    * Método (abstrato) que devolve um double com o valor do custo de ingresso deste local
    * 
    * @return 
    */
    public abstract double getCustoIngresso();
    
    /**
    * Método (abstrato) que devolve um objecto do tipo Guestlist que inclui a guestlist deste local
    * 
    * @return 
    */
    public abstract Guestlist getGuestlist();

    /**
    * Método que devolve uma String com todos os dados deste Local
    * 
    * 
    * @return coordenadas deste Local
    */
    @Override
    public String toString() {
        return "Local { " + coordenadas + " }";
    }
    
    /**
    * Método da classe Comparable usado para ordenar uma ArrayList de objectos do tipo Local por ordem decrescente do nº de inscritos em cada
    * 
    * 
    * @param o Local a comparar
    * @return diferença do número de inscritos deste Local e do passado como parâmetro
    */
    @Override
    public int compareTo(Object o) {
        int localNumInscritos = ((Local)o).getNumInscritos();
        return localNumInscritos - this.getNumInscritos();
    }
}
