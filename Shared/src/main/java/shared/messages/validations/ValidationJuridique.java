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
public class ValidationJuridique extends Validation {

    public ValidationJuridique(Long idDemandeValidation) {
        super(idDemandeValidation);
    }
    
    public ValidationJuridique(Long idDemandeValidation, boolean valide, String causeRefus) {
        super(idDemandeValidation, valide, causeRefus);
    }

    
}
