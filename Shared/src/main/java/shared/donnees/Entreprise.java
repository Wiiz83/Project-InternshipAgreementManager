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
public class Entreprise implements Serializable {

    private String siret;
    private String nom;
    private String mail; 

    public Entreprise(String siret, String nom, String mail) {
        this.siret = siret;
        this.nom = nom;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    
    public String getSiret() {
        return siret;
    }

    public String getNom() {
        return nom;
    }
    
    @Override
    public String toString() {
        return "Entreprise{" + "siret=" + siret + ", nom=" + nom + '}';
    }
}
