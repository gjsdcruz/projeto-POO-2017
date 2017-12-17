/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruna
 */
public class Gestao {
    protected ArrayList<Local> listaLocais;
    protected ArrayList<Pessoa> listaPessoas;
    protected Convivio convivioPOO;
    protected int userID;
    
    public Gestao() throws IOException {
         /* 
        listaLocais = carregaLocaisTxt();
        listaPessoas = carregaPessoasTxt();
        convivioPOO = new Convivio(this.listaLocais, new Data(22,12,2017));
         */
        
        // /*
        listaLocais = carregaLocais();
        listaPessoas = carregaPessoas();
        convivioPOO = carregaConvivio();
        // */
        
        userID = -1;
        escreveFicheiros();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public ArrayList<Local> carregaLocaisTxt() throws IOException {
        ArrayList<Local> listaL = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader("ListaLocais.txt"));
        String lat, lon, tipo, atributoExtra1, atributoExtra2;
        String desportos[];
        ArrayList<String> desportosFinal = new ArrayList<>();

        for(int i=0; (tipo = br.readLine())!=null; i=i++) {
            lat = br.readLine();
            lon = br.readLine();
            atributoExtra1 = br.readLine();
            atributoExtra2 = br.readLine();

            if(tipo.equalsIgnoreCase("Area desportiva")) {
                try{
                    desportos = atributoExtra1.split(",");
                    ArrayList<String> listaDesportos = new ArrayList<>(desportos.length);
                    for(int j=0; j<desportos.length; j++) {
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
            else {}
        }

        br.close();
        return listaL;
    }
    
    public ArrayList<Pessoa> carregaPessoasTxt() throws IOException {
        ArrayList<Pessoa> listaP = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader("ListaPessoas.txt"));
        String nome, tipo, atributoExtra, perfil, password;

        for(int i=0; (nome = br.readLine())!=null; i=i++) {
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
            else {}
        }

        br.close();
        return listaP;
    }
        
    public ArrayList<Local> carregaLocais() throws IOException {
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
    
    public ArrayList<Pessoa> carregaPessoas() throws IOException {
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
    
    public Convivio carregaConvivio() throws IOException {
        Convivio c = new Convivio();
        
        try {
            FileInputStream fis = new FileInputStream("Convivio.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            c = (Convivio) ois.readObject();
            ois.close();
        } catch (FileNotFoundException Exception) {
            System.out.println("Nao encontrou o ficheiro.");
        } catch (Exception e) {
            System.out.println("Erro, nao encontrou o convivio.");
        }
        
        return c;
    }
    
    public void escreveListaLocais(ArrayList<Local> locais) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("ListaLocais.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(locais);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro Local");
        }
    }
    
    public void escreveListaPessoas(ArrayList<Pessoa> pessoas) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("ListaPessoas.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pessoas);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro Pessoa");
        }
    }
    
    public void escreveConvivio(Convivio c) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("Convivio.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(c);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro Convivio");
        }
    }
    
    public void escreveFicheiros() throws IOException {
        escreveListaLocais(this.listaLocais);
        escreveListaPessoas(this.listaPessoas);
        escreveConvivio(this.convivioPOO);
    }
    
    public String chamaLogin(String username, String password) {
        return login(this.listaPessoas, username, password);
    }
    
    public String chamaApresentacaoLocais() {
        return this.convivioPOO.apresentaLocaisAVisitar();
    }
    
    public String chamaSelecaoLocais(String numLocal) {
        return selecaoLocais(this.listaPessoas, this.convivioPOO, numLocal);
    }
    
    public String chamaSeriacaoLocais() {
        return this.convivioPOO.seriacaoLocaisAVisitar();
    }
    
    public String chamaVisualizacaoGuestlist() {
        return this.convivioPOO.visualizaGuestlists();
    }
    
    public String chamaContabilizacaoReceitas() {
        this.convivioPOO.calculaReceita();
        double receita = this.convivioPOO.getReceitaPrevista();
        return "Receita mínima prevista: " + String.valueOf(new DecimalFormat("#.##").format(receita)) + "€\n";
    }

    public void chamaSair() throws IOException {
        escreveFicheiros();
        System.exit(0);
    }
    
    public String login(ArrayList<Pessoa> pessoas, String nome, String password) {
        int i = 0;
        for(Pessoa user : pessoas) {
            if(nome.equalsIgnoreCase(user.getNome())) {
                if(password.equalsIgnoreCase(user.getPassword())) {
                    this.setUserID(i);
                    if(this.convivioPOO.verificaInscricao(user))
                        return "Bem vindo(a) " + user.getNome() + 
                                "\nJá se encontra inscrito(a) no convívio\n";
                    else {
                        this.convivioPOO.inscrevePessoa(user);
                        try {
                            escreveConvivio(this.convivioPOO);
                        } catch (IOException ex) {
                            Logger.getLogger(Gestao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return "Bem vindo(a) " + user.getNome() + 
                                "\nFoi inscrito(a) com sucesso no convívio\n" +
                                this.convivioPOO.apresentaLocaisAVisitar();
                    }
                }
                return "Erro2"; // Erro 2: Password errada.
            }
            i++;
        }
        return "Erro1"; // Erro 1: Não existe ninguém registado com esse nome.
    }
    
    public String selecaoLocais(ArrayList<Pessoa> pessoas, Convivio convivio, String numLocal) {
        int op;
        if(pessoas.get(this.getUserID()).verificaSelecao())
            return "Erro1"; // Erro 1: Já selecionou 5 locais
        else {
            try {
                op = Integer.parseInt(numLocal);
            }
            catch(NumberFormatException e) {
                return "Erro2";  // Erro 2: Deve introduzir um inteiro
            }
            if(op < 1 || op > convivio.getListaLocaisAVisitar().size())
                return "Erro3"; // Erro 3: Opção inválida
            
            String s = pessoas.get(this.getUserID()).adicionaLocal(convivio, op-1);
            if(!s.equalsIgnoreCase("Erro4") && !s.equalsIgnoreCase("Erro5")) {
                try {
                    escreveFicheiros();
                } catch (IOException ex) {
                    Logger.getLogger(Gestao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            return s;
        }
    }
}
