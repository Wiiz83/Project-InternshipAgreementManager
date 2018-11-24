/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.donnees;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author uzanl
 */
public class Departement implements Serializable, HasKey{

    private final String nom;
    private final Set<Diplome> diplomes  = new HashSet<>(); 

    /**
     *
     */
    public Long id ;

    /**
     *
     * @param nom
     */
    public Departement(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Departement{" + " nom=" + nom + "}";
    }

    /**
     *
     * @param d
     */
    public void ajouterDiplome(Diplome d) {
        this.diplomes.add(d);
    }

    /**
     *
     * @return
     */
    public Set<Diplome> getDiplomes() {
        return diplomes;
    }

    /**
     *
     * @return
     */
    @Override
    public Long getKey() {
        return this.id;
    }

    /**
     *
     * @param key
     */
    @Override
    public void setKey(Long key) {
        id = key;
    }
    
    

 

}
