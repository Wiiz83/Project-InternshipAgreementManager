/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.donnees;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Departement implements Serializable, HasKey{

    private final String nom;
    private final Set<Diplome> diplomes  = new HashSet<>(); 
    public Long id ;

    public Departement(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Departement{" + " nom=" + nom + "}";
    }

    public void ajouterDiplome(Diplome d) {
        this.diplomes.add(d);
    }

    public Set<Diplome> getDiplomes() {
        return diplomes;
    }

    @Override
    public Long getKey() {
        return this.id;
    }

    @Override
    public void setKey(Long key) {
        id = key;
    }
    
    

 

}
