/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.donnees.reference;

import java.util.ArrayList;

/**
 *
 * @author Mahdi
 */
class Departement {
    public ArrayList<Diplome> diplomes;
    public String nom;

        public Departement(String nom) {
        this.nom = nom;
        this.diplomes = new ArrayList<>();
    }
    
    boolean ajouterDiplome (Diplome d) {
        d.setDepartement(this);
        return diplomes.add(d);
    }
    
}
