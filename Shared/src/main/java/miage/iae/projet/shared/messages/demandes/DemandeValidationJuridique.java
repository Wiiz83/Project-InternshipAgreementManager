/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages.demandes;

import miage.iae.projet.shared.donnees.Entreprise;
import miage.iae.projet.shared.donnees.Etudiant;
import miage.iae.projet.shared.donnees.ResponsabiliteCivile;
import miage.iae.projet.shared.donnees.Stage;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationJuridique extends DemandeValidation {

    public ResponsabiliteCivile responsabiliteCivile;
    public Stage stage;
    public Entreprise entreprise;

    public DemandeValidationJuridique() {
        super();
        this.responsabiliteCivile = new ResponsabiliteCivile();
        this.stage = new Stage();
        this.entreprise = new Entreprise();
    }

    public DemandeValidationJuridique(ResponsabiliteCivile responsabiliteCivile, Stage stage, Entreprise entreprise) {
        this.responsabiliteCivile = responsabiliteCivile;
        this.stage = stage;
        this.entreprise = entreprise;
    }

    public DemandeValidationJuridique(ResponsabiliteCivile responsabiliteCivile, Stage stage, Entreprise entreprise, int idDemandeConvention, Etudiant etudiant) {
        super(idDemandeConvention, etudiant);
        this.responsabiliteCivile = responsabiliteCivile;
        this.stage = stage;
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "DemandeValidationJuridique{" + "responsabiliteCivile=" + responsabiliteCivile + ", stage=" + stage + ", entreprise=" + entreprise + '}' + super.toString();
    }
    
    
}
