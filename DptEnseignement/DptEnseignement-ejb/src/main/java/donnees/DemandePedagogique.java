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

    /**
     *
     * @param demande
     */
    public DemandePedagogique(DemandeValidationPedagogique demande) {
        this.demande = demande;
    }

    /**
     *
     * @return
     */
    public DemandeValidationPedagogique getDemande() {
        return demande;
    }

    /**
     *
     * @return
     */
    public Boolean getValidationFinale() {
        return validationFinale;
    }

    /**
     *
     * @param validationFinale
     */
    public void setValidationFinale(Boolean validationFinale) {
        this.validationFinale = validationFinale;
    }

    /**
     *
     * @return
     */
    public ValidationPedagogique getValidation() {
        return validation;
    }

    /**
     *
     * @param validation
     */
    public void setValidation(ValidationPedagogique validation) {
        this.validation = validation;
    }
    
    @Override
    public String toString() {
        return "DemandePedagogique{" + "demande=" + demande + ", confirmation=" + validation + ", validationFinale=" + validationFinale + '}';
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
