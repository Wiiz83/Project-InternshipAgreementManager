/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.toulouse.shared.messages.demandes;

import com.miage.toulouse.shared.messages.Diplome;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationAdministrative extends DemandeValidation{
    public Diplome diplome;
    DemandeValidationAdministrative() {
        super();
        this.diplome= new Diplome();
    }
}
