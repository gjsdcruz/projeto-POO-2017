/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Estudante. Herda os métodos da superclasse: Pessoa
 *
 */
public class Estudante extends Pessoa {
    private String curso;
    
    /**
    * Construtor por omissão de objetos da classe Estudante
    * 
    */
    public Estudante() {}

    /**
    * Construtor de objetos da classe Estudante
    * 
    * @param nome nome do Estudante (primeiro e último)
    * @param perfil perfil do Estudante (pode ser Desportivo, Cultural, Boémio ou Poupadinho)
    * @param password password do Estudante
    * @param curso curso do Estudante
    */
    public Estudante(String nome, String perfil, String password, String curso) {
        super(nome, perfil, password);
        this.curso = curso;
    }

    /**
    * Método que devolve uma String com o curso deste Estudante
    * 
    *
    * @return curso deste Estudante
    */
    @Override
    public String getCurso() {
        return curso;
    }

    /**
    * Método que atribui a este Estudante uma String com o curso
    * 
    * 
    * @param curso curso a atribuir a este Estudante
    */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
    * Método que devolve uma String com o tipo de pessoa deste objecto
    * 
    *
    * @return tipo de pessoa (neste caso, Estudante)
    */
    @Override
    public String isType() {return "Estudante";}
    
    /**
    * Método para averiguar se uma pessoa tem direito a um desconto. Devolve true se a pessoa for Estudante, e false, caso contrário
    * 
    *
    * @return true, visto que um Estudante tem direito ao desconto
    */
    @Override
    public boolean isDesconto() {return true;}
    
    /**
    * Método que devolve uma String com todos os dados deste Estudante
    * 
    * 
    * @return todos os atributos da super classe (nome, perfil e password) e o curso
    */
    @Override
    public String toString() {
        return super.toString() + "\nCurso: " + curso;
    }
}
