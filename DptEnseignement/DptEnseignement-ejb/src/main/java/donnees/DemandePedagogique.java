/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import shared.messages.validations.ValidationPedagogique;
import shared.donnees.HasKey;
import shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author Mahdi
 */
public class DemandePedagogique implements HasKey {

    DemandeValidationPedagogique demande;
    ValidationPedagogique validation;
    Boolean validationFinale;

    public DemandePedagogique(DemandeValidationPedagogique demande) {
        this.demande = demande;
    }

    public DemandeValidationPedagogique getDemande() {
        return demande;
    }


    public Boolean getValidationFinale() {
        return validationFinale;
    }

    public void setValidationFinale(Boolean validationFinale) {
        this.validationFinale = validationFinale;
    }

    public ValidationPedagogique getValidation() {
        return validation;
    }

    public void setValidation(ValidationPedagogique validation) {
        this.validation = validation;
    }
    
    @Override
    public String toString() {
        return "DemandePedagogique{" + "demande=" + demande + ", confirmation=" + validation + ", validationFinale=" + validationFinale + '}';
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
