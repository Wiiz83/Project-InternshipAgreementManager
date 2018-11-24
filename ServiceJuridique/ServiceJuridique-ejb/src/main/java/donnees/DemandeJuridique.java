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

    /**
     *
     * @param demande
     */
    public DemandeJuridique(DemandeValidationJuridique demande) {
        this.demande = demande;
    }

    /**
     *
     * @return
     */
    public DemandeValidationJuridique getDemande() {
        return demande;
    }

    /**
     *
     * @param demande
     */
    public void setDemande(DemandeValidationJuridique demande) {
        this.demande = demande;
    }

    /**
     *
     * @return
     */
    public ValidationJuridique getConfirmation() {
        return confirmation;
    }

    /**
     *
     * @param confirmation
     */
    public void setConfirmation(ValidationJuridique confirmation) {
        this.confirmation = confirmation;
    }

    /**
     *
     * @return
     */
    @Override
    public Long getKey() {
        return this.demande.getIdDemandeConvention();
    }

    /**
     *
     * @param key
     */
    @Override
    public void setKey(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
