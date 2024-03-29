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

    /**
     *
     * @param idDemandeConvention
     * @param responsabiliteCivile
     * @param stage
     * @param entreprise
     * @param etudiant
     */
    public DemandeValidationJuridique(Long idDemandeConvention,ResponsabiliteCivile responsabiliteCivile, Stage stage, Entreprise entreprise,  Etudiant etudiant) {
        super(idDemandeConvention, etudiant);
        this.responsabiliteCivile = responsabiliteCivile;
        this.stage = stage;
        this.entreprise = entreprise;
    }

    /**
     *
     * @return
     */
    public ResponsabiliteCivile getResponsabiliteCivile() {
        return responsabiliteCivile;
    }

    /**
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

    /**
     *
     * @return
     */
    public Entreprise getEntreprise() {
        return entreprise;
    }
    

    @Override
    public String toString() {
        return "DemandeValidationJuridique{" + "responsabiliteCivile=" + responsabiliteCivile + ", stage=" + stage + ", entreprise=" + entreprise + '}' + super.toString();
    }
    
    
}
