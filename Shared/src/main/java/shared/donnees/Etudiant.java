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

    public String numero;
    public String nom;
    public String prenom;

    public Etudiant(String numero, String nom, String prenom) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant() {
    }
    
    

    @Override
    public String toString() {
        return "Etudiant{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
}
