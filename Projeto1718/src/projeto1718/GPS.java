/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.Serializable;

/**
 * Classe que contém todas as informações e métodos que involvam os objetos de classe GPS.
 *
 */
public class GPS implements Serializable {
    private double latitude;
    private double longitude;
    
    /**
    * Construtor por omissão de objetos da classe GPS
    * 
    */
    public GPS() {}

    /**
    * Construtor de objetos da classe GPS
    * 
    * @param latitude latitude das coordenadas GPS
    * @param longitude longitude das coordenadas GPS
    */
    public GPS(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
    * Método que devolve um double com o valor da latitude destas coordenadas GPS
    * 
    *
    * @return latitude destas coordenadas GPS
    */
    public double getLatitude() {
        return latitude;
    }

    /**
    * Método que atribui a estas coordenadas GPS um double com o valor da latitude
    * 
    * 
    * @param latitude latitude a atribuir a estas coordenadas GPS
    */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
    * Método que devolve um double com o valor da longitude destas coordenadas GPS
    * 
    *
    * @return longitude destas coordenadas GPS
    */
    public double getLongitude() {
        return longitude;
    }

    /**
    * Método que atribui a estas coordenadas GPS um double com o valor da longitude
    * 
    * 
    * @param longitude longitude a atribuir a estas coordenadas GPS
    */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
    * Método que devolve uma String com todos os dados destas coordenadas GPS
    * 
    * 
    * @return latitude e longitude
    */
    @Override
    public String toString() {
        return latitude + "º, " + longitude + 'º';
    }
}
