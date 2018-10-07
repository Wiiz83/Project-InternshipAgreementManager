/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbourse;

import java.io.Serializable;

/**
 *
 * @author uzanl
 */
public class TitreBoursier implements Serializable {
    
    private String mnemonique;
    private String nom;
    private double cours;
    private double variation;
    

    public String getMnemonique() {
        return mnemonique;
    }

    public void setMnemonique(String mnemonique) {
        this.mnemonique = mnemonique;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getCours() {
        return cours;
    }

    public void setCours(double cours) {
        this.cours = cours;
    }

    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
    }
    
    
    
}
