/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

/**
 *
 * @author Bruna
 */
public class Funcionario extends Pessoa {
    private String regime;
    
    public Funcionario() {}

    public Funcionario(String nome, String perfil, String password, String regime) {
        super(nome, perfil, password);
        this.regime = regime;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    @Override
    public boolean isEstudante() {return false;}
    
    @Override
    public String toString() {
        return super.toString() + "\nRegime: " + regime;
    }
}
