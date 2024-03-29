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

    /**
     *
     */
    public String niveau;

    /**
     *
     */
    public String intitule;
    private Departement departement;

    /**
     *
     */
    public Diplome() {
    }

    /**
     *
     * @param niveau
     * @param intitule
     */
    public Diplome(String niveau, String intitule) {
        this.niveau = niveau;
        this.intitule = intitule;
    }

    /**
     *
     * @param departement
     */
    public void setDepartement(Departement departement) {
        this.departement = departement;
        departement.ajouterDiplome(this);
    }

    /**
     *
     * @return
     */
    public String getNiveau() {
        return niveau;
    }

    /**
     *
     * @return
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     *
     * @return
     */
    public Departement getDepartement() {
        return departement;
    }

    @Override
    public String toString() {
        return "Diplome{" + "niveau=" + niveau + ", intitule=" + intitule + ", departement=" + departement + '}';
    }

}
