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
public class ValidationAdministrative extends Validation {

    public ValidationAdministrative(Long idDemandeValidation) {
        super(idDemandeValidation);
    }

    public ValidationAdministrative(Long idDemandeValidation, boolean valide, String causeRefus) {
        super(idDemandeValidation, valide, causeRefus);
    }

    @Override
    public String getVolet() {
        return "Administratif";
    }

}
