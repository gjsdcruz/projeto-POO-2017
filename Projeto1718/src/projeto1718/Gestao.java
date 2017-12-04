/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.*;
import java.util.*;

/**
 *
 * @author Bruna
 */
public class Gestao {
    protected ArrayList<Local> listaLocais;
    protected ArrayList<Pessoa> listaPessoas;
    protected Convivio convivioPOO;
    
    public Gestao() throws IOException {
        listaLocais = /*carregaLocaisTxt();*/ carregaLocais();
        listaPessoas = /*carregaPessoasTxt();*/ carregaPessoas();
        convivioPOO = new Convivio(listaLocais, new Data(22,12,2017));
        menu();
    }
    
    public ArrayList<Local> carregaLocaisTxt() throws IOException {
        ArrayList<Local> listaL = new ArrayList<>();
        
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
            else {}
        }

        br.close();
        return listaL;
    }
    
    public ArrayList<Pessoa> carregaPessoasTxt() throws IOException {
        ArrayList<Pessoa> listaP = new ArrayList<>();
        
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
    
    public void escreveFicheiros() throws IOException {
        escreveListaLocais(listaLocais);
        escreveListaPessoas(listaPessoas);
    }
    
    public void menu() throws IOException {
        int op = 0;
        while(op != 7){
            op = 0;
            
            System.out.println("========================== MENU ==========================");
            System.out.println("1 - Inscrição no convívio");
            System.out.println("2 - Apresentação dos locais a visitar");
            System.out.println("3 - Seleção dos locais a visitar");
            System.out.println("4 - Seriação dos locais a visitar");
            System.out.println("5 - Visualização das 'guestlist'");
            System.out.println("6 - Contabilização das receitas dos locais visitados");
            System.out.println("7 - Sair");
            System.out.println("==========================================================");
            
            while(op < 1 || op > 7){
                System.out.print("Introduza a opção desejada: ");
                Scanner sc = new Scanner(System.in);
                try{
                    op = sc.nextInt();
                }
                catch(InputMismatchException e){
                    op = 0;
                    System.out.println("Erro! Deve introduzir um inteiro de 1 a 7 de acordo com a opção desejada.");
                }
                if(op < 1 || op > 11)
                    System.out.println("Erro! Deve introduzir um inteiro de 1 a 7 de acordo com a opção desejada.");
            }
            
            switch(op){
                case 1:
                    chamaInscricaoConvivio(); break;
                case 2:
                    chamaApresentacaoLocais(); break;
                case 3:
                    chamaSelecaoLocais(); break;
                case 4:
                    chamaSeriacaoLocais(); break;
                case 5:
                    chamaVisualizacaoGuestlist(); break;
                case 6:
                    chamaContabilizacaoReceitas(); break;
                case 7:
                    chamaSair(); break;
                default:
                    break;
            }
        }
    }

    public void chamaInscricaoConvivio() {
        inscricaoConvivio(this.convivioPOO, this.listaPessoas);
    }

    public void chamaApresentacaoLocais() {
        apresentacaoLocais(this.convivioPOO);
    }

    public void chamaSelecaoLocais() {
        
    }

    public void chamaSeriacaoLocais() {
        
    }

    public void chamaVisualizacaoGuestlist() {
        
    }

    public void chamaContabilizacaoReceitas() {
        
    }

    public void chamaSair() throws IOException {
        escreveFicheiros();
        System.exit(0);
    }

    public boolean inscricaoConvivio(Convivio c, ArrayList<Pessoa> pessoas) {
        String nome, password;
        
        System.out.println("Nome: ");
        Scanner sc = new Scanner(System.in);
        nome = sc.nextLine();
        System.out.println("Password: ");
        password = sc.nextLine();
        
        for(Pessoa p : pessoas){
            if(nome.equalsIgnoreCase(p.getNome()) && password.equals(p.getPassword())){
                if(c.inscrevePessoa(p)){
                    System.out.println("Foi inscrito com sucesso");
                    return true;
                } else return false;
            }
        }
        
        System.out.println("Não existe ninguém com esse nome / Password errada");
        return false;
    }

    private void apresentacaoLocais(Convivio c) {
        int i = 0;
        for(Local l : c.getListaLocaisAVisitar()){
            System.out.println(l);
            System.out.println("Inscritos: " + c.getMapaInscritos().get(i));
            i++;
        }
    }
}
