/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import shared.donnees.HasKey;
import shared.messages.validations.ValidationAdministrative;
import shared.messages.demandes.DemandeValidationAdministrative;

/**
 *
 * @author Mahdi
 */
public class DemandeAdministrative implements HasKey {

    private DemandeValidationAdministrative demande;
    private ValidationAdministrative validation;

    public DemandeAdministrative(DemandeValidationAdministrative demande) {
        this.demande = demande;
    }

    public DemandeValidationAdministrative getDemande() {
        return demande;
    }

    public void setDemande(DemandeValidationAdministrative demande) {
        this.demande = demande;
    }

    public ValidationAdministrative getValidation() {
        return validation;
    }

    public void setValidation(ValidationAdministrative validation) {
        this.validation = validation;
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
