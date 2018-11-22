/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m2.eai.clientrest.metiersiren;

/**
 *
 * Geometry
 *
 * @author Cédric Teyssié  <cedric.teyssie@irit.fr>, IRIT-SIERA, Université Paul Sabatier
 * @version 0.1, 2 oct. 2018
 * @since 0.1, 2 oct. 2018
 */
// ClientREST-INSEE
// fr.miage.toulouse.m2.eai.clientrest.metiersiren
// Geometry.java
public class Geometry {

    private String type;

    private String[] coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "ClassPojo [type = " + type + ", coordinates = " + coordinates + "]";
    }
}
