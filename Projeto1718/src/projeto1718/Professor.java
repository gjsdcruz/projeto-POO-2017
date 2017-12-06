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
public class Professor extends Pessoa {
    private String categoria;
    
    public Professor() {}

    public Professor(String nome, String perfil, String password, String categoria) {
        super(nome, perfil, password);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean isEstudante() {return false;}
    
    @Override
    public boolean isFuncionario() {return false;}
    
    @Override
    public boolean isProfessor() {return true;}
    
    @Override
    public String toString() {
        return super.toString() + "\nCategoria: " + categoria;
    }
}
