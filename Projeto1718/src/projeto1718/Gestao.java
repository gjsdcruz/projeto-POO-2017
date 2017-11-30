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
    protected ArrayList<Local> listaLocais;
    protected ArrayList<Pessoa> listaPessoas;
    
    public Gestao() {
        listaLocais = carregaLocaisTxt(); //carregaLocais();
        listaPessoas = carregaPessoasTxt(); //carregaPessoas();
        
        menu();
    }
    
    public ArrayList<Local> carregaLocaisTxt() {
        ArrayList<Local> listaL = new ArrayList<>();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("ListaLocais.txt"));
            String lat, lon, tipo, atributoExtra1, atributoExtra2;
            String desportos[];
            ArrayList<String> desportosFinal = new ArrayList<>();

            for(int i=0; (tipo = br.readLine())!=null; i=i++){
                lat = br.readLine();
                lon = br.readLine();
                atributoExtra1 = br.readLine();
                atributoExtra2 = br.readLine();

                if(tipo.equalsIgnoreCase("Area desportiva")){
                    try{
                        desportos = atributoExtra1.split(",");
                        ArrayList<String> listaDesportos = new ArrayList<>(desportos.length);
                        for(int j=0; j<desportos.length; j++){
                            listaDesportos.add(desportos[j]);
                        }
                        desportosFinal = listaDesportos;
                    }
                    catch(Exception e) {
                        ArrayList<String> listaDesportos = new ArrayList<>(1);
                        listaDesportos.add(atributoExtra1);
                        desportosFinal = listaDesportos;
                    }
                    listaL.add(new AreaDesportiva(new GPS(Double.valueOf(lat), Double.valueOf(lon)), desportosFinal));
                }
                else if(tipo.equalsIgnoreCase("Jardim"))
                    listaL.add(new Jardim(new GPS(Double.valueOf(lat), Double.valueOf(lon)), Double.valueOf(atributoExtra1)));
                else if(tipo.equalsIgnoreCase("Exposicao"))
                    listaL.add(new Exposicao(new GPS(Double.valueOf(lat), Double.valueOf(lon)), atributoExtra1, Double.valueOf(atributoExtra2)));
                else if(tipo.equalsIgnoreCase("Bar"))
                    listaL.add(new Bar(new GPS(Double.valueOf(lat), Double.valueOf(lon)), Integer.valueOf(atributoExtra1), Double.valueOf(atributoExtra2)));
            }
            
            br.close();
            return listaL;
        } catch (IOException ex) {
            Logger.getLogger(Gestao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaL;
    }
    
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
        
    public ArrayList<Local> carregaLocais() {
        ArrayList<Local> listaL = new ArrayList<>();
        
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
        escreveListaLocais(this.listaLocais);
        escreveListaPessoas(this.listaPessoas);
    }
    
     public void menu() {
         
     }
}
