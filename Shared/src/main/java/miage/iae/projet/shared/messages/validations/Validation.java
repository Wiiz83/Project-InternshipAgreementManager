/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages.validations;

import java.io.Serializable;


/**
 *
 * @author Mahdi
 */
public abstract class Validation implements Serializable {
    public Long idDemandeValidation;
    public boolean confirmation;
    public String causeRefus;

    Validation(Long idDemandeValidation, boolean confirmation, String causeRefus) {
        this.idDemandeValidation = idDemandeValidation;
        this.confirmation = confirmation;
        this.causeRefus = causeRefus;
    }

    @Override
    public String toString() {
        return "Validation{" + "idDemandeValidation=" + idDemandeValidation + ", confirmation=" + confirmation + ", causeRefus=" + causeRefus + '}';
    }
    
}
