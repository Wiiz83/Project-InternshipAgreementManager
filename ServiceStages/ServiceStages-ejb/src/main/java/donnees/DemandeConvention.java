/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import java.io.Serializable;
import shared.donnees.ConfirmationAdministrative;
import shared.donnees.ConfirmationJuridique;
import shared.donnees.ConfirmationPedagogique;
import shared.donnees.Diplome;
import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.ResponsabiliteCivile;
import shared.donnees.Stage;

/**
 *
 * @author Mahdi
 */
public class DemandeConvention implements Serializable {
    private int id;
   
    private Etudiant etudiant;
    private Diplome diplome;
    private ResponsabiliteCivile responsabiliteCivile;
    private Stage stage;
    private Entreprise entreprise;
    
    private ConfirmationJuridique confirmationJuridique;
    private ConfirmationPedagogique confirmationPedagogique;
    private ConfirmationAdministrative confirmationAdministrative;
    
    public DemandeConvention(Etudiant etudiant, Diplome diplome, ResponsabiliteCivile responsabiliteCivile, Stage stage, Entreprise entreprise) {
        this.etudiant = etudiant;
        this.diplome = diplome;
        this.responsabiliteCivile = responsabiliteCivile;
        this.stage = stage;
        this.entreprise = entreprise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public ResponsabiliteCivile getResponsabiliteCivile() {
        return responsabiliteCivile;
    }

    public void setResponsabiliteCivile(ResponsabiliteCivile responsabiliteCivile) {
        this.responsabiliteCivile = responsabiliteCivile;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }    
    
    public void setConfirmationJuridique(ConfirmationJuridique confirmationJuridique) {
        this.confirmationJuridique = confirmationJuridique;
    }

    public void setConfirmationPedagogique(ConfirmationPedagogique confirmationPedagogique) {
        this.confirmationPedagogique = confirmationPedagogique;
    }

    public void setConfirmationAdministrative(ConfirmationAdministrative confirmationAdministrative) {
        this.confirmationAdministrative = confirmationAdministrative;
    }
    
    @Override
    public String toString() {
        return "DemandeConvention{" + "etudiant=" + etudiant + ", diplome=" + diplome + ", responsabiliteCivile=" + responsabiliteCivile + ", stage=" + stage + ", entreprise=" + entreprise + '}';
    }
    
}
