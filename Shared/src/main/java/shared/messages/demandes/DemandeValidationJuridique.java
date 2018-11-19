/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.demandes;

import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.ResponsabiliteCivile;
import shared.donnees.Stage;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationJuridique extends DemandeValidation {

    private ResponsabiliteCivile responsabiliteCivile;
    private Stage stage;
    private Entreprise entreprise;


    public DemandeValidationJuridique(Long idDemandeConvention,ResponsabiliteCivile responsabiliteCivile, Stage stage, Entreprise entreprise,  Etudiant etudiant) {
        super(idDemandeConvention, etudiant);
        this.responsabiliteCivile = responsabiliteCivile;
        this.stage = stage;
        this.entreprise = entreprise;
    }

    public void setResponsabiliteCivile(ResponsabiliteCivile responsabiliteCivile) {
        this.responsabiliteCivile = responsabiliteCivile;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
    

    @Override
    public String toString() {
        return "DemandeValidationJuridique{" + "responsabiliteCivile=" + responsabiliteCivile + ", stage=" + stage + ", entreprise=" + entreprise + '}' + super.toString();
    }
    
    
}
