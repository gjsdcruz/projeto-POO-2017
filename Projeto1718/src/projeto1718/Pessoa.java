/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Bruna
 */
public abstract class Pessoa implements Serializable {
    protected String nome;
    protected String perfil;
    protected String password;
    protected boolean desconto;
    protected ArrayList<Local> listaLocaisSelecionados;
    
    public Pessoa() {}

    public Pessoa(String nome, String perfil, String password) {
        this.nome = nome;
        this.perfil = perfil;
        this.password = password;
        this.desconto = false;
        this.listaLocaisSelecionados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Local> getListaLocaisSelecionados() {
        return listaLocaisSelecionados;
    }

    public void setListaLocaisSelecionados(ArrayList<Local> listaLocaisSelecionados) {
        this.listaLocaisSelecionados = listaLocaisSelecionados;
    }
    
    public abstract String isType();
    
    public abstract boolean isDesconto();
    
    public abstract String getCurso();
    
    @Override
    public String toString() {
        return "Nome: " + nome + "\nPerfil: " + perfil + "\nPassword: " + password;
    }
    
    public boolean verificaSelecao() {
        if(this.getListaLocaisSelecionados().size() == 5) {
            return true;
        }
        return false;
    }
    
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
    
    public boolean verificaPerfilBoemio() {
        if(this.getPerfil().equalsIgnoreCase("Boemio")) {
            return true;
        }
        else return false;
    }
}
