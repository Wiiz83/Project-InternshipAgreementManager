/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages.demandes;

import miage.iae.projet.shared.donnees.reference.Diplome;
import miage.iae.projet.shared.donnees.Entreprise;
import miage.iae.projet.shared.donnees.Etudiant;
import miage.iae.projet.shared.donnees.Stage;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationPedagogique extends DemandeValidation {

    public Stage stage;
    public Entreprise entreprise;
    public Diplome diplome;

    public DemandeValidationPedagogique(Stage stage, Entreprise entreprise, Diplome diplome) {
        this.stage = stage;
        this.entreprise = entreprise;
        this.diplome = diplome;
    }

    public DemandeValidationPedagogique(Stage stage, Entreprise entreprise, Diplome diplome, int idDemandeConvention, Etudiant etudiant) {
        super(idDemandeConvention, etudiant);
        this.stage = stage;
        this.entreprise = entreprise;
        this.diplome = diplome;
    }

    @Override
    public String toString() {
        return "DemandeValidationPedagogique{" + "stage=" + stage + ", entreprise=" + entreprise + ", diplome=" + diplome + '}' + super.toString();
    }
    
    

}
