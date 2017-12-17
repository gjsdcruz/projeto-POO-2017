/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.util.ArrayList;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe AreaDesportiva. Herda os métodos da superclasse: Local
 *
 */
public class AreaDesportiva extends Local {
    private ArrayList<String> desportos;
    
    /**
    * Construtor por omissão de objetos da classe AreaDesportiva
    *
    */
    public AreaDesportiva() {}

    /**
    * Construtor de objetos da classe AreaDesportiva
    * 
    * @param coordenadas coordenadas da AreaDesportiva
    * @param desportos desportos que se podem praticar na AreaDesportiva
    */
    public AreaDesportiva(GPS coordenadas, ArrayList<String> desportos) {
        super(coordenadas);
        this.desportos = desportos;
    }

    /**
    * Método que devolve uma ArrayList de objectos da classe String que contém os desportos que se podem praticar nesta AreaDesportiva
    * 
    *
    * @return lista de desportos desta AreaDesportiva
    */
    public ArrayList<String> getDesportos() {
        return desportos;
    }

    /**
    * Método que atribui a esta AreaDesportiva uma ArrayList de objectos da classe String com os desportos que se podem praticar
    * 
    * 
    * @param desportos lista de desportos a atribuir a esta AreaDesportiva
    */
    public void setDesportos(ArrayList<String> desportos) {
        this.desportos = desportos;
    }
    
    /**
    * Método que devolve uma String com o tipo de local deste objecto
    * 
    *
    * @return tipo de local (neste caso, AreaDesportiva)
    */
    @Override
    public String isType() {return "AreaDesportiva";}
    
    /**
    * Método que devolve um int com o valor da lotação deste local. Retorna -1 se o método for invocado sobre um objecto que não seja do tipo Bar
    * 
    *
    * @return -1, visto que uma AreaDesportiva não tem lotação
    */
    @Override
    public int getLotacao() {return -1;}
    
    /**
    * Método que devolve um double com o valor do consumo mínimo deste local. Retorna -1 se o método for invocado sobre um objecto que não seja do tipo Bar
    * 
    *
    * @return -1, visto que uma AreaDesportiva não tem consumo mínimo
    */
    @Override
    public double getConsumoMinimo() {return -1;}
    
    /**
    * Método que devolve um double com o valor do custo de ingresso deste local. Retorna -1 se o método for invocado sobre um objecto que não seja do tipo Exposicao
    * 
    *
    * @return -1, visto que uma AreaDesportiva não tem custo de ingresso
    */
    @Override
    public double getCustoIngresso() {return -1;}
    
    /**
    * Método que devolve um objecto do tipo Guestlist que inclui a guestlist deste local. Retorna null se o método for invocado sobre um objecto que não seja do tipo Bar
    * 
    *
    * @return null, visto que uma AreaDesportiva não tem guestlist
    */
    @Override
    public Guestlist getGuestlist() {return null;}
    
    /**
    * Método que devolve uma String com todos os dados desta AreaDesportiva
    * 
    * 
    * @return coordenadas, o tipo de local (neste caso, AreaDesportiva) e os desportos que nele se podem praticar
    */
    @Override
    public String toString() {
        return super.toString() + "\nÁrea Desportiva\nDesportos: " + desportos.toString();
    }
}
