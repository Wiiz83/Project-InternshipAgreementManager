/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.demandes;

import java.io.Serializable;
import shared.donnees.Diplome;
import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.ResponsabiliteCivile;
import shared.donnees.Stage;

/**
 *
 * @author Mahdi
 */
public class DemandeConventionMessage implements Serializable {

    private Etudiant etudiant;
    private Diplome diplome;
    private ResponsabiliteCivile responsabiliteCivile;
    private Stage stage;
    private Entreprise entreprise;

    public DemandeConventionMessage(Etudiant etudiant, Diplome diplome, ResponsabiliteCivile responsabiliteCivile, Stage stage, Entreprise entreprise) {
        this.etudiant = etudiant;
        this.diplome = diplome;
        this.responsabiliteCivile = responsabiliteCivile;
        this.stage = stage;
        this.entreprise = entreprise;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public ResponsabiliteCivile getResponsabiliteCivile() {
        return responsabiliteCivile;
    }

    public Stage getStage() {
        return stage;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    @Override
    public String toString() {
        return "DemandeConventionMessage{" + "etudiant=" + etudiant + ", diplome=" + diplome + ", responsabiliteCivile=" + responsabiliteCivile + ", stage=" + stage + ", entreprise=" + entreprise + '}';
    }  
    
}
