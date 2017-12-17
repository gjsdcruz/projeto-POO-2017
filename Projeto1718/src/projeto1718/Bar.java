/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Bar. Herda os métodos da superclasse: Local
 *
 */
public class Bar extends Local {
    private int lotacao;
    private double consumoMinimo;
    private Guestlist guestlist;
    
    /**
    * Construtor por omissão de objetos da classe Bar
    * 
    */
    public Bar() {}

    /**
    * Construtor de objetos da classe Bar
    * 
    * @param coordenadas coordenadas do Bar
    * @param lotacao lotação do Bar
    * @param consumoMinimo consumo mínimo no Bar
    */
    public Bar(GPS coordenadas, int lotacao, double consumoMinimo) {
        super(coordenadas);
        this.lotacao = lotacao;
        this.consumoMinimo = consumoMinimo;
        // Definimos que o nº máximo de convidados da guestlist corresponde a 50% da lotação do bar
        this.guestlist = new Guestlist(this.lotacao / 2);
    }

    /**
    * Método que devolve um int com o valor da lotação deste local
    * 
    *
    * @return lotação deste Bar
    */
    @Override
    public int getLotacao() {
        return lotacao;
    }

    /**
    * Método que atribui a este Bar um int com o valor da lotação
    * 
    * 
    * @param lotacao lotação a atribuir a este Bar
    */
    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    /**
    * Método que devolve um double com o valor do consumo mínimo deste local
    * 
    *
    * @return consumo mínimo deste Bar
    */
    @Override
    public double getConsumoMinimo() {
        return consumoMinimo;
    }

    /**
    * Método que atribui a este Bar um double com o valor do consumo mínimo
    * 
    * 
    * @param consumoMinimo consumo mínimo a atribuir a este Bar
    */
    public void setConsumoMinimo(double consumoMinimo) {
        this.consumoMinimo = consumoMinimo;
    }

    /**
    * Método que devolve um objecto do tipo Guestlist que inclui a guestlist deste local
    * 
    *
    * @return consumo mínimo deste Bar
    */
    @Override
    public Guestlist getGuestlist() {
        return guestlist;
    }

    /**
    * Método que atribui a este Bar um objecto do tipo Guestlist que inclui a guestlist
    * 
    * 
    * @param guestlist guestlist a atribuir a este Bar
    */
    public void setGuestlist(Guestlist guestlist) {
        this.guestlist = guestlist;
    }
    
    /**
    * Método que devolve uma String com o tipo de local deste objecto
    * 
    *
    * @return tipo de local (neste caso, Bar)
    */
    @Override
    public String isType() {return "Bar";}
    
    /**
    * Método que devolve um double com o valor do custo de ingresso deste local. Retorna -1 se o método for invocado sobre um objecto que não seja do tipo Exposicao
    * 
    *
    * @return -1, visto que um Bar não tem custo de ingresso
    */
    @Override
    public double getCustoIngresso() {return -1;}

    /**
    * Método que devolve uma String com todos os dados deste Bar
    * 
    * 
    * @return coordenadas, o tipo de local (neste caso, Bar), e a sua lotação e consumo mínimo
    */
    @Override
    public String toString() {
        return super.toString() + "\nBar\nLotação: " + lotacao + "\nConsumo mínimo: " + consumoMinimo + "€";
    }
}
