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
public class Etudiant implements Serializable {

    private String numero;
    private String nom;
    private String prenom;
    private String mail;

    public Etudiant(String numero, String nom, String prenom, String mail) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    public Etudiant() {
    }

    public String getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }  

    public String getMail() {
        return mail;
    }
    
    @Override
    public String toString() {
        return "Etudiant{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
}
