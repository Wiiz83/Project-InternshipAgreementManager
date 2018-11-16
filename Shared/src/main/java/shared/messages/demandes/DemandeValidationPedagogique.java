/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.demandes;

import shared.donnees.Diplome;
import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.Stage;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationPedagogique extends DemandeValidation {

    private Stage stage;
    private Entreprise entreprise;
    private Diplome diplome;

    public DemandeValidationPedagogique(Stage stage, Entreprise entreprise, Diplome diplome, Long idDemandeConvention, Etudiant etudiant) {
        super(idDemandeConvention, etudiant);
        this.stage = stage;
        this.entreprise = entreprise;
        this.diplome = diplome;
    }

    public Stage getStage() {
        return stage;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    @Override
    public String toString() {
        return "DemandeValidationPedagogique{" + "stage=" + stage + ", entreprise=" + entreprise + ", diplome=" + diplome + '}' + super.toString();
    }
    
    

}
