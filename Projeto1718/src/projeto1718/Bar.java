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
public class Bar extends Local {
    private int lotacao;
    private double consumoMinimo;
    private Guestlist guestlist;
    
    public Bar() {}

    public Bar(GPS coordenadas, int lotacao, double consumoMinimo) {
        super(coordenadas);
        this.lotacao = lotacao;
        this.consumoMinimo = consumoMinimo;
        // Definimos que o nº máximo de convidados da guestlist corresponde a 50% da lotação do bar
        this.guestlist = new Guestlist(this.lotacao / 2);
    }

    @Override
    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public double getConsumoMinimo() {
        return consumoMinimo;
    }

    public void setConsumoMinimo(double consumoMinimo) {
        this.consumoMinimo = consumoMinimo;
    }

    public Guestlist getGuestlist() {
        return guestlist;
    }

    public void setGuestlist(Guestlist guestlist) {
        this.guestlist = guestlist;
    }
    
    @Override
    public String isType() {return "Bar";}
    
    @Override
    public double getCustoIngresso() {return -1;}

    @Override
    public String toString() {
        return super.toString() + "\nBar\nLotação: " + lotacao + "\nConsumo mínimo: " + consumoMinimo + "€";
    }
}
