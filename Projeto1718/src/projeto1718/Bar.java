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
    
    public Bar() {}

    public Bar(GPS coordenadas, int lotacao, double consumoMinimo) {
        super(coordenadas);
        this.lotacao = lotacao;
        this.consumoMinimo = consumoMinimo;
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
    
    @Override
    public boolean isAreaDesportiva() {return false;}
    
    @Override
    public boolean isBar() {return true;}
    
    @Override
    public boolean isExposicao() {return false;}
    
    @Override
    public boolean isJardim() {return false;}

    @Override
    public String toString() {
        return super.toString() + "\nBar {Lotação: " + lotacao + ", Consumo mínimo: " + consumoMinimo + "€}";
    }
}
