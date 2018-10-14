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
    Long idDemandeValidation;
    public boolean confirmation;
    public String causeRefus;
}
