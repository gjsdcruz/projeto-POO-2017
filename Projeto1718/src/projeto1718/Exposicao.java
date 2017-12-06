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
public class Exposicao extends Local {
    private String formaArtistica;
    private double custoIngresso;
    
    public Exposicao() {}

    public Exposicao(GPS coordenadas, String formaArtistica, double custoIngresso) {
        super(coordenadas);
        this.formaArtistica = formaArtistica;
        this.custoIngresso = custoIngresso;
    }

    public String getFormaArtistica() {
        return formaArtistica;
    }

    public void setFormaArtistica(String formaArtistica) {
        this.formaArtistica = formaArtistica;
    }

    public double getCustoIngresso() {
        return custoIngresso;
    }

    public void setCustoIngresso(double custoIngresso) {
        this.custoIngresso = custoIngresso;
    }

    @Override
    public int getLotacao() {return -1;}
    
    @Override
    public boolean isAreaDesportiva() {return false;}
    
    @Override
    public boolean isBar() {return false;}
    
    @Override
    public boolean isExposicao() {return true;}
    
    @Override
    public boolean isJardim() {return false;}
    
    @Override
    public String toString() {
        return super.toString() + "\nExposição {Forma artística: " + formaArtistica + ", Custo de ingresso: " + custoIngresso + "€}";
    }
}
