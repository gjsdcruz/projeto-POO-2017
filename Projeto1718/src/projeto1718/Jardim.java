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
public class Jardim extends Local {
    private double area;
    
    public Jardim() {}

    public Jardim(GPS coordenadas, double area) {
        super(coordenadas);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString() + "\nJardim {Área: " + area + " m^2}";
    }
}
