/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Professor. Herda os métodos da superclasse: Pessoa
 *
 */
public class Professor extends Pessoa {
    private String categoria;
    
    /**
    * Construtor por omissão de objetos da classe Professor
    * 
    */
    public Professor() {}

    /**
    * Construtor de objetos da classe Professor
    * 
    * @param nome nome do Professor (primeiro e último)
    * @param perfil perfil do Professor (pode ser Desportivo, Cultural, Boémio ou Poupadinho)
    * @param password password do Professor
    * @param categoria categoria do Professor (pode ser Auxiliar, Associado ou Catedrático)
    */
    public Professor(String nome, String perfil, String password, String categoria) {
        super(nome, perfil, password);
        this.categoria = categoria;
    }

    /**
    * Método que devolve uma String com a categoria deste Professor
    * 
    *
    * @return categoria deste Professor
    */
    public String getCategoria() {
        return categoria;
    }

    /**
    * Método que atribui a este Professor uma String com a categoria
    * 
    * 
    * @param categoria categoria a atribuir a este Professor
    */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
    * Método que devolve uma String com o tipo de pessoa deste objecto
    * 
    *
    * @return tipo de pessoa (neste caso, Professor)
    */
    @Override
    public String isType() {return "Professor";}
    
    /**
    * Método para averiguar se uma pessoa tem direito a um desconto. Devolve true se a pessoa for Estudante, e false, caso contrário
    * 
    *
    * @return false, visto que um Professor não tem direito ao desconto
    */
    @Override
    public boolean isDesconto() {return false;}
    
    /**
    * Método que devolve uma String com o curso desta pessoa. Devolve uma String vazia se o método for invocado sobre um objecto que não seja do tipo Estudante
    * 
    *
    * @return "", visto que um Professor não tem um curso
    */
    @Override
    public String getCurso() {return "";}
    
    /**
    * Método que devolve uma String com todos os dados deste Professor
    * 
    * 
    * @return todos os atributos da super classe (nome, perfil e password) e a categoria
    */
    @Override
    public String toString() {
        return super.toString() + "\nCategoria: " + categoria;
    }
}
