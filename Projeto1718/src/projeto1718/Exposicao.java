/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe Exposicao. Herda os métodos da superclasse: Local
 *
 */
public class Exposicao extends Local {
    private String formaArtistica;
    private double custoIngresso;
    
    /**
    * Construtor por omissão de objetos da classe Exposicao
    * 
    */
    public Exposicao() {}
    
    /**
    * Construtor de objetos da classe Exposicao
    * 
    * @param coordenadas coordenadas da Exposicao
    * @param formaArtistica forma artística da Exposicao (pode ser Pintura, Escultura, ou outra)
    * @param custoIngresso custo de ingresso da Exposicao
    */
    public Exposicao(GPS coordenadas, String formaArtistica, double custoIngresso) {
        super(coordenadas);
        this.formaArtistica = formaArtistica;
        this.custoIngresso = custoIngresso;
    }

    /**
    * Método que devolve uma String com a forma artística desta Exposicao
    * 
    *
    * @return forma artística desta Exposicao
    */
    public String getFormaArtistica() {
        return formaArtistica;
    }

    /**
    * Método que atribui a esta Exposicao uma String com a forma artística
    * 
    * 
    * @param formaArtistica forma artística a atribuir a esta Exposicao
    */
    public void setFormaArtistica(String formaArtistica) {
        this.formaArtistica = formaArtistica;
    }

    /**
    * Método que devolve um double com o valor do custo de ingresso desta Exposicao
    * 
    *
    * @return custo de ingresso desta Exposicao
    */
    @Override
    public double getCustoIngresso() {
        return custoIngresso;
    }

    /**
    * Método que atribui a esta Exposicao um double com o valor do custo de ingresso
    * 
    * 
    * @param custoIngresso custo de ingresso a atribuir a esta Exposicao
    */
    public void setCustoIngresso(double custoIngresso) {
        this.custoIngresso = custoIngresso;
    }
    
    /**
    * Método que devolve uma String com o tipo de local deste objecto
    * 
    *
    * @return tipo de local (neste caso, Exposicao)
    */
    @Override
    public String isType() {return "Exposicao";}
    
    /**
    * Método que devolve um int com o valor da lotação deste local. Retorna -1 se o método for invocado sobre um objecto que não seja do tipo Bar
    * 
    *
    * @return -1, visto que uma Exposicao não tem lotação
    */
    @Override
    public int getLotacao() {return -1;}
    
    /**
    * Método que devolve um double com o valor do consumo mínimo deste local. Retorna -1 se o método for invocado sobre um objecto que não seja do tipo Bar
    * 
    *
    * @return -1, visto que uma Exposicao não tem consumo mínimo
    */
    @Override
    public double getConsumoMinimo() {return -1;}
    
    /**
    * Método que devolve um objecto do tipo Guestlist que inclui a guestlist deste local. Retorna null se o método for invocado sobre um objecto que não seja do tipo Bar
    * 
    *
    * @return null, visto que uma Exposicao não tem guestlist
    */
    @Override
    public Guestlist getGuestlist() {return null;}
    
    /**
    * Método que devolve uma String com todos os dados desta Exposicao
    * 
    * 
    * @return coordenadas, o tipo de local (neste caso, Exposicao), e a sua forma artística e custo de ingresso
    */
    @Override
    public String toString() {
        return super.toString() + "\nExposição\nForma artística: " + formaArtistica +
                "\nCusto de ingresso: " + custoIngresso + "€";
    }
}
