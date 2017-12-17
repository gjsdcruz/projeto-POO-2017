/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Data.
 *
 */
public class Data implements Serializable {
    private int dia;
    private int mes;
    private int ano;
    
    /**
    * Construtor por omissão de objetos da classe Data
    * 
    */
    public Data() {}

    /**
    * Construtor de objetos da classe Data
    * 
    * @param dia dia da Data
    * @param mes mês da Data
    * @param ano ano da Data
    */
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
    * Método que devolve um int com o valor do dia desta Data
    * 
    *
    * @return dia desta Data
    */
    public int getDia() {
        return dia;
    }

    /**
    * Método que atribui a esta Data um int com o valor do dia
    * 
    * 
    * @param dia dia a atribuir a esta Data
    */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
    * Método que devolve um int com o valor do mês desta Data
    * 
    *
    * @return mês desta Data
    */
    public int getMes() {
        return mes;
    }

    /**
    * Método que atribui a esta Data um int com o valor do mês
    * 
    * 
    * @param mes mês a atribuir a esta Data
    */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
    * Método que devolve um int com o valor do ano desta Data
    * 
    *
    * @return ano desta Data
    */
    public int getAno() {
        return ano;
    }

    /**
    * Método que atribui a esta Data um int com o valor do ano
    * 
    * 
    * @param ano ano a atribuir a esta Data
    */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
    * Método que devolve uma String com todos os dados desta Data
    * 
    * 
    * @return dia, mês e ano
    */
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
