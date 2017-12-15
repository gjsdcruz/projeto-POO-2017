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
public class Estudante extends Pessoa {
    private String curso;
    
    public Estudante() {}

    public Estudante(String nome, String perfil, String password, String curso) {
        super(nome, perfil, password);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String isType() {return "Estudante";}
    
    @Override
    public boolean isDesconto() {return true;}
    
    @Override
    public String toString() {
        return super.toString() + "\nCurso: " + curso;
    }
}
