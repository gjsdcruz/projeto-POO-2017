/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Jardim. Herda os métodos da superclasse: Local
 *
 */
public class Jardim extends Local {
    private double area;
    
    /**
    * Construtor por omissão de objetos da classe Jardim
    * 
    */
    public Jardim() {}

    /**
    * Construtor de objetos da classe Jardim
    * 
    * @param coordenadas coordenadas do Jardim
    * @param area area (em metros quadrados) do Jardim
    */
    public Jardim(GPS coordenadas, double area) {
        super(coordenadas);
        this.area = area;
    }

    /**
    * Método que devolve um double com o valor da área deste Jardim
    * 
    *
    * @return área deste Jardim
    */
    public double getArea() {
        return area;
    }

    /**
    * Método que atribui a este Jardim um double com o valor da área
    * 
    * 
    * @param area área a atribuir a este Jardim
    */
    public void setArea(double area) {
        this.area = area;
    }
    
    /**
    * Método que devolve uma String com o tipo de local deste objecto
    * 
    *
    * @return tipo de local (neste caso, Jardim)
    */
    @Override
    public String isType() {return "Jardim";}
    
    /**
    * Método que devolve um int com o valor da lotação deste local. Retorna -1 se o método for invocado sobre um objecto que não seja do tipo Bar
    * 
    *
    * @return -1, visto que um Jardim não tem lotação
    */
    @Override
    public int getLotacao() {return -1;}
    
    /**
    * Método que devolve um double com o valor do consumo mínimo deste local. Retorna -1 se o método for invocado sobre um objecto que não seja do tipo Bar
    * 
    *
    * @return -1, visto que um Jardim não tem consumo mínimo
    */
    @Override
    public double getConsumoMinimo() {return -1;}
    
    /**
    * Método que devolve um double com o valor do custo de ingresso deste local. Retorna -1 se o método for invocado sobre um objecto que não seja do tipo Exposicao
    * 
    *
    * @return -1, visto que um Jardim não tem custo de ingresso
    */
    @Override
    public double getCustoIngresso() {return -1;}
    
    /**
    * Método que devolve um objecto do tipo Guestlist que inclui a guestlist deste local. Retorna null se o método for invocado sobre um objecto que não seja do tipo Bar
    * 
    *
    * @return null, visto que um Jardim não tem guestlist
    */
    @Override
    public Guestlist getGuestlist() {return null;}
    
    /**
    * Método que devolve uma String com todos os dados deste Jardim
    * 
    * 
    * @return coordenadas, o tipo de local (neste caso, Jardim) e a sua área
    */
    @Override
    public String toString() {
        return super.toString() + "\nJardim\nÁrea: " + area + " m^2";
    }
}
