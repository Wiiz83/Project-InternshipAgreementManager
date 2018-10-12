/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.toulouse.shared.messages.validations;

import com.miage.toulouse.shared.messages.demandes.DemandeValidation;

/**
 *
 * @author Mahdi
 */
public abstract class Validation {
    Long idDemandeValidation;
    public boolean confirmation;
    public String causeRefus;
}
