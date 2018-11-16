/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import shared.donnees.ConfirmationPedagogique;
import shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author Mahdi
 */
public class DemandePedagogique {

    DemandeValidationPedagogique demande;
    ConfirmationPedagogique confirmation;
    Boolean validationFinale;

    public DemandePedagogique(DemandeValidationPedagogique demande) {
        this.demande = demande;
    }

    public DemandeValidationPedagogique getDemande() {
        return demande;
    }

    public ConfirmationPedagogique getConfirmation() {
        return confirmation;
    }

    public Boolean getValidationFinale() {
        return validationFinale;
    }

    public void setValidationFinale(Boolean validationFinale) {
        this.validationFinale = validationFinale;
    }

    public void setConfirmation(ConfirmationPedagogique confirmation) {
        this.confirmation = confirmation;
    }
}
