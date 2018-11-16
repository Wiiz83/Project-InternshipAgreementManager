/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.validations;

import java.io.Serializable;


/**
 *
 * @author Mahdi
 */
public abstract class Validation implements Serializable {
    private Long idDemandeValidation;
    private boolean confirmation;
    private String causeRefus;

    Validation(Long idDemandeValidation, boolean confirmation, String causeRefus) {
        this.idDemandeValidation = idDemandeValidation;
        this.confirmation = confirmation;
        this.causeRefus = causeRefus;
    }

    public Long getIdDemandeValidation() {
        return idDemandeValidation;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public String getCauseRefus() {
        return causeRefus;
    }  
    
    @Override
    public String toString() {
        return "Validation{" + "idDemandeValidation=" + idDemandeValidation + ", confirmation=" + confirmation + ", causeRefus=" + causeRefus + '}';
    }
    
}
