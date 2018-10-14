/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages;

import java.io.Serializable;

/**
 *
 * @author Mahdi
 */
public class Entreprise implements Serializable {

    public String siret;
    public String nom;

    public Entreprise(String siret, String nom) {
        this.siret = siret;
        this.nom = nom;
    }

    public Entreprise() {
    }
    

    @Override
    public String toString() {
        return "Entreprise{" + "siret=" + siret + ", nom=" + nom + '}';
    }
}
