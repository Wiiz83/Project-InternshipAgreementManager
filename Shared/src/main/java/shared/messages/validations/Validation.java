/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.validations;

import java.io.Serializable;
import shared.donnees.HasKey;

/**
 *
 * @author Mahdi
 */
public abstract class Validation implements Serializable, HasKey {

    private Long idDemandeValidation;
    private final boolean valide;
    private final String causeRefus;


    public Validation(Long idDemandeValidation,boolean valide, String causeRefus) {
        this.idDemandeValidation = idDemandeValidation; 
        this.valide = valide;
        this.causeRefus = causeRefus;
    }


    protected Validation(Long idDemandeValidation) {
        this.idDemandeValidation=idDemandeValidation;
        this.valide = true;
        causeRefus = null;
    }

    public boolean isValide() {
        return valide;
    }
    
    abstract public String getVolet();

    public Long getIdDemandeValidation() {
        return idDemandeValidation;
    }

    public String getCauseRefus() {
        return causeRefus;
    }

    @Override
    public String toString() {
        return "Validation{" + "idDemandeValidation=" + idDemandeValidation + ", confirmation=" + valide + ", causeRefus=" + causeRefus + '}';
    }

    @Override
    public Long getKey() {
        return this.idDemandeValidation;
    }

    @Override
    public void setKey(Long key) {
        this.idDemandeValidation = key;
    }

}
