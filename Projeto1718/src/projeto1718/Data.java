/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.util.Calendar;

/**
 *
 * @author Bruna
 */
public class Data {
    private int dia;
    private int mes;
    private int ano;
    
    public Data() {}

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
    
    public boolean verificaDataParametros(Data d) {
        if(this.ano >= 2017){
            if(this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12){
                return this.dia >= 1 && this.dia <=31;
            }
            else if(this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11){
                return this.dia >= 1 && this.dia <=30;
            }
            else if(this.mes == 2){
                return this.dia >= 1 && this.dia <=28;
            }
            else return false;
        }
        else return false;
    }
    
    public boolean verificaDataValidez(Data d) {
        Calendar atual = Calendar.getInstance();
        int diaAtual = atual.get(Calendar.DAY_OF_MONTH);
        int mesAtual = atual.get(Calendar.MONTH);
        mesAtual += 1;
        int anoAtual = atual.get(Calendar.YEAR);
        
        if(d.getAno() < anoAtual) return false;
        else{
            if(d.getAno() == anoAtual){
                if(d.getMes() < mesAtual) return false;
                else{
                    if(d.getMes() == mesAtual){
                        return d.getDia() >= diaAtual;
                    }
                    else return true;
                }
            }
            else return true;
        }
    }
}
