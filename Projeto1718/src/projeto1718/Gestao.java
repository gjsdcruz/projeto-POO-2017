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
         /* 
        listaLocais = carregaLocaisTxt();
        listaPessoas = carregaPessoasTxt();
        convivioPOO = new Convivio(this.listaLocais, new Data(22,12,2017));
        escreveFicheiros();
         */
        
        // /*
        listaLocais = carregaLocais();
        listaPessoas = carregaPessoas();
        convivioPOO = carregaConvivio();
        //escreveFicheiros();
        menu(this.listaLocais, this.listaPessoas, this.convivioPOO);
        // */
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
    
    public void menu(ArrayList<Local> locais, ArrayList<Pessoa> pessoas, Convivio convivio) throws IOException {
        int [] numPessoa = new int[1];
        while(login(pessoas, numPessoa) == false) {}
        int i = numPessoa[0];
        
        System.out.println("Bem vindo(a) " + pessoas.get(i).getNome());
        if(convivio.verificaInscricao(pessoas.get(i)) == false) {
            convivio.inscrevePessoa(pessoas.get(i));
            System.out.println("Foi inscrito(a) com sucesso no convívio.");
            convivio.apresentaLocaisAVisitar();
        }
        
        int op = 0;
        while(op != 6) {
            op = 0;
            
            System.out.println("========================== MENU ==========================");
            System.out.println("1 - Seleção dos locais a visitar");
            System.out.println("2 - Seriação dos locais a visitar");
            System.out.println("3 - Visualização das 'guestlist'");
            System.out.println("4 - Contabilização das receitas dos locais visitados");
            System.out.println("5 - Logout");
            System.out.println("6 - Sair");
            
            while(op < 1 || op > 6) {
                System.out.print("Introduza a opção desejada: ");
                Scanner sc = new Scanner(System.in);
                try {
                    op = sc.nextInt();
                }
                catch(InputMismatchException e) {
                    op = 0;
                    System.out.println("Erro! Deve introduzir um inteiro de 1 a 6 de acordo com a opção desejada.");
                }
                if(op < 1 || op > 6)
                    System.out.println("Erro! Deve introduzir um inteiro de 1 a 6 de acordo com a opção desejada.");
            }
            
            switch(op) {
                case 1:
                    chamaSelecaoLocais(convivio, pessoas.get(i)); break;
                case 2:
                    chamaSeriacaoLocais(convivio); break;
                case 3:
                    chamaVisualizacaoGuestlist(convivio); break;
                case 4:
                    chamaContabilizacaoReceitas(convivio); break;
                case 5:
                    menu(locais, pessoas, convivio); break;
                case 6:
                    chamaSair(); break;
                default:
                    break;
            }
        }
    }

    public void chamaSelecaoLocais(Convivio convivio, Pessoa pessoa) throws IOException {
        if(pessoa.verificaSelecao() == false) {
            convivio.apresentaLocaisAVisitar();
            selecaoLocais(convivio, pessoa);
        }
    }

    public void chamaSeriacaoLocais(Convivio convivio) {
        seriacaoLocais(convivio);
    }

    public void chamaVisualizacaoGuestlist(Convivio convivio) {
        visualizacaoGuestlists(convivio);
    }

    public void chamaContabilizacaoReceitas(Convivio convivio) {
        contabilizacaoReceitas(convivio);
    }

    public void chamaSair() throws IOException {
        escreveFicheiros();
        System.exit(0);
    }
    
    public boolean login(ArrayList<Pessoa> pessoas, int numPessoa[]) {
        String nome, password;
        
        System.out.println("======= LOGIN =======");
        System.out.print("Nome: ");
        Scanner sc = new Scanner(System.in);
        nome = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();
        
        for(int i=0; i<pessoas.size(); i++) {
            if(nome.equalsIgnoreCase(pessoas.get(i).getNome())) {
                if(password.equalsIgnoreCase(pessoas.get(i).getPassword())) {
                    numPessoa[0] = i;
                    return true;
                }
                else {
                    System.out.println("Password errada.");
                    return false;
                }
            }
        }
        System.out.println("Não existe ninguém registado com esse nome.");
        return false;
    }

    public void selecaoLocais(Convivio convivio, Pessoa pessoa) throws IOException {
        int op = 0;
        Scanner sc = new Scanner(System.in);

        while(op < 1 || op > convivio.getListaLocaisAVisitar().size()) {
            try {
                System.out.print("Introduza o nº do local a visitar: ");
                op = sc.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("Opção inválida. Introduza um número inteiro.");
                op = 0;
            }
        }

        if(pessoa.adicionaLocal(convivio, op-1))
            System.out.println("Local adicionado com sucesso");
    }
    
    public void seriacaoLocais(Convivio convivio) {
        convivio.seriacaoLocaisAVisitar();
    }
    
    public void visualizacaoGuestlists(Convivio convivio) {
        convivio.visualizaGuestlists();
    }
    
    public void contabilizacaoReceitas(Convivio convivio) {
        convivio.calculaReceita();
        System.out.printf("Receita mínima prevista:  %.2f€\n", convivio.getReceitaPrevista());
    }
}
