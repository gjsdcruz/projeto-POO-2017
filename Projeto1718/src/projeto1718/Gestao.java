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
        convivioPOO = /*new Convivio(this.listaLocais, new Data(22,12,2017));*/ carregaConvivio();
        //escreveFicheiros();
        
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
    
    public void menu() throws IOException {
        int [] j = new int[1];
        while(login(this.listaPessoas, j) == false) {}
        
        if(verificaInscricao(this.convivioPOO, this.listaPessoas.get(j[0])) == false){
            if(inscricaoConvivio(this.convivioPOO, this.listaPessoas, this.listaPessoas.get(j[0])))
                System.out.println("Foi inscrito com sucesso no convívio");
            apresentacaoLocais(this.convivioPOO);
        }
        
        int op = 0;
        while(op != 6){
            op = 0;
            
            System.out.println("========================== MENU ==========================");
            System.out.println("1 - Seleção dos locais a visitar");
            System.out.println("2 - Seriação dos locais a visitar");
            System.out.println("3 - Visualização das 'guestlist'");
            System.out.println("4 - Contabilização das receitas dos locais visitados");
            System.out.println("5 - Logout");
            System.out.println("6 - Sair");
            System.out.println("==========================================================");
            
            while(op < 1 || op > 6){
                System.out.print("Introduza a opção desejada: ");
                Scanner sc = new Scanner(System.in);
                try{
                    op = sc.nextInt();
                }
                catch(InputMismatchException e){
                    op = 0;
                    System.out.println("Erro! Deve introduzir um inteiro de 1 a 6 de acordo com a opção desejada.");
                }
                if(op < 1 || op > 6)
                    System.out.println("Erro! Deve introduzir um inteiro de 1 a 6 de acordo com a opção desejada.");
            }
            
            switch(op){
                case 1:
                    chamaSelecaoLocais(this.listaPessoas.get(j[0])); break;
                case 2:
                    chamaSeriacaoLocais(); break;
                case 3:
                    chamaVisualizacaoGuestlist(); break;
                case 4:
                    chamaContabilizacaoReceitas(); break;
                case 5:
                    menu(); break;
                case 6:
                    chamaSair(); break;
                default:
                    break;
            }
        }
    }

    public void chamaSelecaoLocais(Pessoa p) throws IOException {
        selecaoLocais(this.convivioPOO, this.listaPessoas, p);
    }

    public void chamaSeriacaoLocais() {
        seriacaoLocais(this.convivioPOO);
    }

    public void chamaVisualizacaoGuestlist() {
        
    }

    public void chamaContabilizacaoReceitas() {
        
    }

    public void chamaSair() throws IOException {
        escreveFicheiros();
        System.exit(0);
    }
    
    public boolean login(ArrayList<Pessoa> pessoas, int j[]) {
        String nome, password;
        
        System.out.println("======= LOGIN =======");
        System.out.print("Nome: ");
        Scanner sc = new Scanner(System.in);
        nome = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();
        
        for(int i=0; i<pessoas.size(); i++){
            if(nome.equalsIgnoreCase(pessoas.get(i).getNome()) && password.equalsIgnoreCase(pessoas.get(i).getPassword())){
                j[0] = i;
                return true;
            }
        }
        System.out.println("Não existe ninguém com esse nome / Password errada");
        return false;
    }
    
    public boolean verificaInscricao(Convivio c, Pessoa p) {
        if(c.getListaInscritos().isEmpty())
            return false;
        
        for(Pessoa pe : c.getListaInscritos()){
            if(pe.getNome().equalsIgnoreCase(p.getNome())){
                System.out.println("Já se encontra inscrito no convívio");
                return true;
            }
        }
        return false;
    }
    
    public boolean inscricaoConvivio(Convivio c, ArrayList<Pessoa> pessoas, Pessoa p) throws IOException {
        for(int i=0; i<pessoas.size(); i++){
            if(p.getNome().equalsIgnoreCase(pessoas.get(i).getNome())){
                c.getListaInscritos().add(pessoas.get(i));
                escreveConvivio(c);
                return true;
            }
        }
        return false;
    }
    
    public void apresentacaoLocais(Convivio c) {
        int i = 1;
        System.out.println("\n========= LOCAIS A VISITAR =========");
        for(Local l : c.getListaLocaisAVisitar()){
            System.out.println(i + " - " + l);
            if(l.getLotacao() != -1)
                System.out.println("Lotação: " + l.getLotacao());
            System.out.println("Inscritos: " + c.getMapaInscritos().get(i-1));
            i++;
        }
        System.out.println("====================================");
    }

    public void selecaoLocais(Convivio c, ArrayList<Pessoa> pessoas, Pessoa p) throws IOException {
        if(p.getListaLocaisSelecionados().size() == 5)
            System.out.println("Erro! Já selecionou 5 locais.");
        else{
            apresentacaoLocais(c);
            
            int op = 0;
            Scanner sc = new Scanner(System.in);

            while(op < 1 || op > c.getListaLocaisAVisitar().size()){
                try{
                    System.out.print("Introduza o nº do local a visitar: ");
                    op = sc.nextInt();
                }
                catch(InputMismatchException e) {
                    System.out.println("Opção inválida. Introduza um número inteiro.");
                    op = 0;
                }
            }

            if(adicionarLocal(c, op-1, pessoas, p)){
                System.out.println("Local adicionado com sucesso");

                escreveConvivio(c);
                escreveListaPessoas(pessoas);
            }
        }
    }
    
    public boolean adicionarLocal(Convivio c, int i, ArrayList<Pessoa> pessoas, Pessoa p) {
        if(!p.getListaLocaisSelecionados().isEmpty()){
            for(Local l : p.getListaLocaisSelecionados()){
                if(l.equals(c.getListaLocaisAVisitar().get(i))){
                    System.out.println("Erro! Já selecionou este local.");
                    return false;
                }
            }
        }
        
        for(Pessoa pe : pessoas){
            if(pe.getNome().equalsIgnoreCase(p.getNome())){
                if(c.getListaLocaisAVisitar().get(i).isBar()){
                    if(c.getMapaInscritos().get(i) < c.getListaLocaisAVisitar().get(i).getLotacao()){
                        pe.getListaLocaisSelecionados().add(c.getListaLocaisAVisitar().get(i));
                        c.getMapaInscritos().put(i, c.getMapaInscritos().get(i)+1);
                        return true;
                    }
                    else{
                        System.out.println("Erro! Lotação esgotada neste local.");
                        return false;
                    }
                }
                
                pe.getListaLocaisSelecionados().add(c.getListaLocaisAVisitar().get(i));
                c.getMapaInscritos().put(i, c.getMapaInscritos().get(i)+1);
                return true;
                /*
                if(c.getListaLocaisAVisitar().get(i).isAreaDesportiva()){
                    AreaDesportiva a = (AreaDesportiva) c.getListaLocaisAVisitar().get(i);
                    pe.getListaLocaisSelecionados().add(a);
                    c.getMapaInscritos().put(i, c.getMapaInscritos().get(i)+1);
                    return true;
                }
                else if(c.getListaLocaisAVisitar().get(i).isBar()){
                    if(c.getMapaInscritos().get(i) < c.getListaLocaisAVisitar().get(i).getLotacao()){
                        Bar b = (Bar) c.getListaLocaisAVisitar().get(i);
                        pe.getListaLocaisSelecionados().add(b);
                        c.getMapaInscritos().put(i, c.getMapaInscritos().get(i)+1);
                        return true;
                    }
                    else{
                        System.out.println("Erro! Lotação esgotada.");
                        return false;
                    }
                }
                else if(c.getListaLocaisAVisitar().get(i).isExposicao()){
                    Exposicao e = (Exposicao) c.getListaLocaisAVisitar().get(i);
                    pe.getListaLocaisSelecionados().add(e);
                    c.getMapaInscritos().put(i, c.getMapaInscritos().get(i)+1);
                    return true;
                }
                else if(c.getListaLocaisAVisitar().get(i).isJardim()){
                    Jardim j = (Jardim) c.getListaLocaisAVisitar().get(i);
                    pe.getListaLocaisSelecionados().add(j);
                    c.getMapaInscritos().put(i, c.getMapaInscritos().get(i)+1);
                    return true;
                }
                else {return false;}
                */
            }
        }
        return false;
    }
    
    public void seriacaoLocais(Convivio c) {
        
    }
}
