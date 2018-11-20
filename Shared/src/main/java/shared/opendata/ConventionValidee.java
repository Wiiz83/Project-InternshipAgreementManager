/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.opendata;

import java.util.Date;
import shared.donnees.Diplome;

/**
 *
 * @author Mahdi
 */
public class ConventionValidee {

    private int anneeUniversitaire;
    private Diplome diplome;
    private String departement;
    private String entreprise;
    private Date debut;
    private Date fin;
    private double gratification;

    public ConventionValidee(int anneeUniversitaire, Diplome diplome, String departement, String entreprise, Date debut, Date fin, double gratification) {
        this.anneeUniversitaire = anneeUniversitaire;
        this.diplome = diplome;
        this.departement = departement;
        this.entreprise = entreprise;
        this.debut = debut;
        this.fin = fin;
        this.gratification = gratification;
    }
}
