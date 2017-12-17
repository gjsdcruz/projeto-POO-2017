/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Funcionario. Herda os métodos da superclasse: Pessoa
 *
 */
public class Funcionario extends Pessoa {
    private String regime;
    
    /**
    * Construtor por omissão de objetos da classe Funcionario
    * 
    */
    public Funcionario() {}

    /**
    * Construtor de objetos da classe Funcionario
    * 
    * @param nome nome do Funcionario (primeiro e último)
    * @param perfil perfil do Funcionario (pode ser Desportivo, Cultural, Boémio ou Poupadinho)
    * @param password password do Funcionario
    * @param regime regime do Funcionario (pode ser Tempo parcial ou Tempo integral)
    */
    public Funcionario(String nome, String perfil, String password, String regime) {
        super(nome, perfil, password);
        this.regime = regime;
    }

    /**
    * Método que devolve uma String com o regime deste Funcionario
    * 
    *
    * @return regime deste Funcionario
    */
    public String getRegime() {
        return regime;
    }

    /**
    * Método que atribui a este Funcionario uma String com o regime
    * 
    * 
    * @param regime regime a atribuir a este Funcionario
    */
    public void setRegime(String regime) {
        this.regime = regime;
    }

    /**
    * Método que devolve uma String com o tipo de pessoa deste objecto
    * 
    *
    * @return tipo de pessoa (neste caso, Funcionario)
    */
    @Override
    public String isType() {return "Funcionario";}
    
    /**
    * Método para averiguar se uma pessoa tem direito a um desconto. Devolve true se a pessoa for Estudante, e false, caso contrário
    * 
    *
    * @return false, visto que um Funcionario não tem direito ao desconto
    */
    @Override
    public boolean isDesconto() {return false;}
    
    /**
    * Método que devolve uma String com o curso desta pessoa. Devolve uma String vazia se o método for invocado sobre um objecto que não seja do tipo Estudante
    * 
    *
    * @return "", visto que um Funcionario não tem um curso
    */
    @Override
    public String getCurso() {return "";}
    
    /**
    * Método que devolve uma String com todos os dados deste Funcionario
    * 
    * 
    * @return todos os atributos da super classe (nome, perfil e password) e o regime
    */
    @Override
    public String toString() {
        return super.toString() + "\nRegime: " + regime;
    }
}
