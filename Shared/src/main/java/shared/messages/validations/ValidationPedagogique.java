/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.validations;

/**
 *
 * @author Mahdi
 */
public class ValidationPedagogique extends Validation {
    public String nomTuteur;

    public ValidationPedagogique(String nomTuteur, Long idDemandeValidation, boolean confirmation, String causeRefus) {
        super(idDemandeValidation, confirmation, causeRefus);
        this.nomTuteur = nomTuteur;
    }

    @Override
    public String toString() {
        return "ValidationPedagogique{" + "nomTuteur=" + nomTuteur + super.toString() +'}';
    }
    
    
    
}
