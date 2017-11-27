/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Bruna
 */
public class Gestao {
    //protected ArrayList<Local> listaLocais;
    protected ArrayList<Pessoa> listaPessoas;
    
    public Gestao() {
        //listaLocais = new ArrayList<>(); //carregaLocais();
        listaPessoas = new ArrayList<>(); //carregaPessoas();
        
        menu();
    }
    
    /*
    public ArrayList<Local> carregaLocais() {
        ArrayList<Local> listaL = new ArrayList<>();
    
        return listaL;
    }
    */
    
    public ArrayList<Pessoa> carregaPessoas() {
        ArrayList<Pessoa> listaP = new ArrayList<>();
        
        return listaP;
    }
    
    /*
    public void escreveListaLocais(ArrayList<Local> locais) {
        try {
            FileOutputStream fos = new FileOutputStream("ListaLocais.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(locais);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro Local");
        }
    }
    */
    
    public void escreveListaPessoas(ArrayList<Pessoa> pessoas) {
        try {
            FileOutputStream fos = new FileOutputStream("ListaPessoas.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pessoas);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro Local");
        }
    }
    
    public void escreveFicheiros() {
        //escreveListaLocais(this.listaLocais);
        escreveListaPessoas(this.listaPessoas);
    }
    
     public void menu() {
         
     }
}
