/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.opendata;

import java.io.Serializable;
import java.util.Date;
import shared.donnees.Diplome;

/**
 *
 * @author Mahdi
 */
public class ConventionValidee implements Serializable {

    public int anneeUniversitaire;
    public Diplome diplome;
    public String departement;
    public String entreprise;
    public Date debut;
    public Date fin;
    public double gratification;

    public ConventionValidee() {
    }

    public ConventionValidee(int anneeUniversitaire, Diplome diplome, String departement, String entreprise, Date debut, Date fin, double gratification) {
        this.anneeUniversitaire = anneeUniversitaire;
        this.diplome = diplome;
        this.departement = departement;
        this.entreprise = entreprise;
        this.debut = debut;
        this.fin = fin;
        this.gratification = gratification;
        this.diplome = new Diplome(diplome.getNiveau(), diplome.getIntitule());
    }
}
