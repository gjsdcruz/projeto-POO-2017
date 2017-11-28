/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruna
 */
public class Gestao {
    //protected ArrayList<Local> listaLocais;
    protected ArrayList<Pessoa> listaPessoas;
    
    public Gestao() {
        //listaLocais = carregaLocaisTxt(); //carregaLocais();
        listaPessoas = carregaPessoasTxt(); //carregaPessoas();
        
        menu();
    }
    
    /*
    public ArrayList<Local> carregaLocaisTxt() {
        ArrayList<Local> listaL = new ArrayList<>();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("ListaLocais.txt"));
            String nome, tipo, atributoExtra, perfil, password;

            for(int i=0; (nome = br.readLine())!=null; i=i++){
                tipo = br.readLine();
                atributoExtra = br.readLine();
                perfil = br.readLine();
                password = br.readLine();

                if(tipo.equalsIgnoreCase("Professor"))
                    listaP.add(new Professor(nome, perfil, password, atributoExtra));
                else if(tipo.equalsIgnoreCase("Funcionario"))
                    listaP.add(new Funcionario(nome, perfil, password, atributoExtra));
                else if(tipo.equalsIgnoreCase("Estudante"))
                    listaP.add(new Estudante(nome, perfil, password, atributoExtra));
            }

            br.close();
            return listaL;
        } catch (IOException ex) {
            Logger.getLogger(Gestao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaL;
    }
    */
    
    public ArrayList<Pessoa> carregaPessoasTxt() {
        ArrayList<Pessoa> listaP = new ArrayList<>();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("ListaPessoas.txt"));
            String nome, tipo, atributoExtra, perfil, password;

            for(int i=0; (nome = br.readLine())!=null; i=i++){
                tipo = br.readLine();
                atributoExtra = br.readLine();
                perfil = br.readLine();
                password = br.readLine();

                if(tipo.equalsIgnoreCase("Professor"))
                    listaP.add(new Professor(nome, perfil, password, atributoExtra));
                else if(tipo.equalsIgnoreCase("Funcionario"))
                    listaP.add(new Funcionario(nome, perfil, password, atributoExtra));
                else if(tipo.equalsIgnoreCase("Estudante"))
                    listaP.add(new Estudante(nome, perfil, password, atributoExtra));
            }

            br.close();
            return listaP;
        } catch (IOException ex) {
            Logger.getLogger(Gestao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaP;
    }
        
    /*
    public ArrayList<Local> carregaLocais() {
        ArrayList<Pessoa> listaL = new ArrayList<>();
        
        try {
            FileInputStream fis = new FileInputStream("ListaLocais.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaL = (ArrayList<Local>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException Exception) {
            System.out.println("Nao encontrou o ficheiro.");
        } catch (Exception e) {
            System.out.println("Erro, nao encontrou o local.");
        }
        
        return listaL;
    }
    */
    
    public ArrayList<Pessoa> carregaPessoas() {
        ArrayList<Pessoa> listaP = new ArrayList<>();
        
        try {
            FileInputStream fis = new FileInputStream("ListaPessoas.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaP = (ArrayList<Pessoa>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException Exception) {
            System.out.println("Nao encontrou o ficheiro.");
        } catch (Exception e) {
            System.out.println("Erro, nao encontrou a pessoa.");
        }
        
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
