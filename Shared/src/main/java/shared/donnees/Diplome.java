/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.donnees;

import java.io.Serializable;

/**
 *
 * @author Mahdi
 */
public class Diplome implements Serializable {

    private final String niveau;
    private final String intitule;
    private Departement departement;

    public Diplome(String niveau, String intitule, Departement departement) {
        this.niveau = niveau;
        this.intitule = intitule;
        this.departement = departement;
    } 
    
    public String getNiveau() {
        return niveau;
    }

    public String getIntitule() {
        return intitule;
    }

    public Departement getDepartement() {
        return departement;
    }

    @Override
    public String toString() {
        return "Diplome{" + "niveau=" + niveau + ", intitule=" + intitule + ", departement=" + departement + '}';
    }

}
