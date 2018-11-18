/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import shared.donnees.HasKey;
import shared.messages.validations.ValidationJuridique;
import shared.messages.demandes.DemandeValidationJuridique;

/**
 *
 * @author Mahdi
 */
public class DemandeJuridique implements HasKey {

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

    @Override
    public Long getKey() {
        return this.demande.getIdDemandeConvention();
    }

    @Override
    public void setKey(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
