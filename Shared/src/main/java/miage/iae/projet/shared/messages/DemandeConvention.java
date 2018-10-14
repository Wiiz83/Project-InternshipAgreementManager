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
public class DemandeConvention implements Serializable {
    public Etudiant etudiant;
    public Diplome diplome;
    public ResponsabiliteCivile responsabiliteCivile;
    public Stage stage;
    public Entreprise entreprise;
    
    public DemandeConvention() {
        this.etudiant = new Etudiant();
        this.diplome = new Diplome();
        this.responsabiliteCivile = new ResponsabiliteCivile();
        this.stage = new Stage();
        this.entreprise = new Entreprise();
    }

    public DemandeConvention(Etudiant etudiant, Diplome diplome, ResponsabiliteCivile responsabiliteCivile, Stage stage, Entreprise entreprise) {
        this.etudiant = etudiant;
        this.diplome = diplome;
        this.responsabiliteCivile = responsabiliteCivile;
        this.stage = stage;
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "DemandeConvention{" + "etudiant=" + etudiant + ", diplome=" + diplome + ", responsabiliteCivile=" + responsabiliteCivile + ", stage=" + stage + ", entreprise=" + entreprise + '}';
    }
    
}
