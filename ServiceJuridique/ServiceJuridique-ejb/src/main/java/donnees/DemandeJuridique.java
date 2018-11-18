/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import shared.messages.validations.ValidationJuridique;
import shared.messages.demandes.DemandeValidationJuridique;

/**
 *
 * @author Mahdi
 */
public class DemandeJuridique {

    private DemandeValidationJuridique demande;
    private ValidationJuridique confirmation;

    public DemandeJuridique(DemandeValidationJuridique demande) {
        this.demande = demande;
    }

    public DemandeValidationJuridique getDemande() {
        return demande;
    }

    public void setDemande(DemandeValidationJuridique demande) {
        this.demande = demande;
    }

    public ValidationJuridique getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(ValidationJuridique confirmation) {
        this.confirmation = confirmation;
    }
    
}
