/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Pessoa.
 *
 */
public abstract class Pessoa implements Serializable {
    protected String nome;
    protected String perfil;
    protected String password;
    protected ArrayList<Local> listaLocaisSelecionados;
    
    /**
    * Construtor por omissão de objetos da classe Pessoa
    * 
    */
    public Pessoa() {}

    /**
    * Construtor de objetos da classe Pessoa
    * 
    * @param nome nome da Pessoa (primeiro e último)
    * @param perfil perfil da Pessoa (pode ser Desportivo, Cultural, Boémio ou Poupadinho)
    * @param password password da Pessoa
    */
    public Pessoa(String nome, String perfil, String password) {
        this.nome = nome;
        this.perfil = perfil;
        this.password = password;
        this.listaLocaisSelecionados = new ArrayList<>();
    }

    /**
    * Método que devolve uma String com o nome desta Pessoa
    * 
    *
    * @return nome desta Pessoa
    */
    public String getNome() {
        return nome;
    }

    /**
    * Método que atribui a esta Pessoa uma String com o nome
    * 
    * 
    * @param nome nome a atribuir a esta Pessoa
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    * Método que devolve uma String com o perfil desta Pessoa
    * 
    *
    * @return perfil desta Pessoa
    */
    public String getPerfil() {
        return perfil;
    }

    /**
    * Método que atribui a esta Pessoa uma String com o perfil
    * 
    * 
    * @param perfil perfil a atribuir a esta Pessoa
    */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
    * Método que devolve uma String com a password desta Pessoa
    * 
    *
    * @return password desta Pessoa
    */
    public String getPassword() {
        return password;
    }

    /**
    * Método que atribui a esta Pessoa uma String com a password
    * 
    * 
    * @param password password a atribuir a esta Pessoa
    */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
    * Método que devolve uma ArrayList de objectos da classe Local que contém os locais que esta Pessoa pretende visitar
    * 
    *
    * @return lista de locais que esta Pessoa selecionou para visitar
    */
    public ArrayList<Local> getListaLocaisSelecionados() {
        return listaLocaisSelecionados;
    }

    /**
    * Método que atribui a esta Pessoa uma ArrayList de objectos da classe Local com os locais que pretende visitar
    * 
    * 
    * @param listaLocaisSelecionados lista de locais para visitar a atribuir a esta Pessoa
    */
    public void setListaLocaisSelecionados(ArrayList<Local> listaLocaisSelecionados) {
        this.listaLocaisSelecionados = listaLocaisSelecionados;
    }
    
    /**
    * Método (abstrato) que devolve uma String com o tipo de pessoa
    * 
    * @return 
    */
    public abstract String isType();
    
    /**
    * Método (abstrato) que devolve true/false consoante o tipo de pessoa
    * 
    * @return 
    */
    public abstract boolean isDesconto();
    
    /**
    * Método (abstrato) que devolve uma String com o curso desta pessoa
    * 
    * @return 
    */
    public abstract String getCurso();
    
    /**
    * Método que devolve uma String com todos os dados desta Pessoa
    * 
    * 
    * @return nome, perfil e password
    */
    @Override
    public String toString() {
        return "Nome: " + nome + "\nPerfil: " + perfil + "\nPassword: " + password;
    }
    
    /**
    * Método que devolve true se esta Pessoa já selecionou 5 locais, e false caso contrário
    * 
    * 
    * @return true ou false
    */
    public boolean verificaSelecao() {
        if(this.getListaLocaisSelecionados().size() == 5) {
            return true;
        }
        return false;
    }
    
    /**
    * Método que devolve uma String com o resultado da adição de um Local à listaLocaisSelecionados desta Pessoa. 
    * 
    * 
    * @param convivio convivio do qual o local a selecionar faz parte
    * @param i número do local na listaLocaisAVisitar de convivio
    * @return resultado da operação (erro ou sucesso)
    */
    public String adicionaLocal(Convivio convivio, int i) {
        String s = "";
        
        if(!this.getListaLocaisSelecionados().isEmpty()) {
            for(Local local : this.getListaLocaisSelecionados()) {
                if(local.equals(convivio.getListaLocaisAVisitar().get(i))) {
                    s = s.concat("Erro4"); // Erro 4: Já selecionou este local
                    return s;
                }
            }
        }
        
        int numInscritos = convivio.getListaLocaisAVisitar().get(i).getNumInscritos();
        int lotacao = convivio.getListaLocaisAVisitar().get(i).getLotacao();
        
        if(convivio.getListaLocaisAVisitar().get(i).isType().equalsIgnoreCase("Bar")) {
            if(numInscritos < lotacao) {
                this.getListaLocaisSelecionados().add(convivio.getListaLocaisAVisitar().get(i));
                convivio.getListaLocaisAVisitar().get(i).setNumInscritos(numInscritos+1);
                
                if(!convivio.getListaLocaisAVisitar().get(i).getGuestlist().adicionaConvidado(this)) {
                    if(this.verificaPerfilBoemio()) {
                        for(Pessoa convidado : convivio.getListaLocaisAVisitar().get(i).getGuestlist().getListaConvidados()) {
                            if(!convidado.verificaPerfilBoemio()) {
                                if(convivio.getListaLocaisAVisitar().get(i).getGuestlist().removeConvidado(convidado))
                                    s = s.concat("Removeu-se " + convidado.getNome() + " da guestlist do bar.\n");
                                if(convivio.getListaLocaisAVisitar().get(i).getGuestlist().adicionaConvidado(this))
                                    s = s.concat("Adicionou-se " + this.getNome() + " à guestlist do bar.\n");
                                break;
                            }
                        }
                    }
                }
                
                s = s.concat("Local adicionado com sucesso\n");
                return s;
            }
            else{
                s = s.concat("Erro5"); // Erro 5 : Lotação esgotada neste bar
                return s;
            }
        }
        
        this.getListaLocaisSelecionados().add(convivio.getListaLocaisAVisitar().get(i));
        convivio.getListaLocaisAVisitar().get(i).setNumInscritos(numInscritos+1);
        s = s.concat("Local adicionado com sucesso\n");
        return s;
    }
    
    /**
    * Método que devolve true se esta Pessoa tem o perfil Boemio, e false caso contrário
    * 
    * 
    * @return true ou false
    */
    public boolean verificaPerfilBoemio() {
        if(this.getPerfil().equalsIgnoreCase("Boemio")) {
            return true;
        }
        else return false;
    }
}
