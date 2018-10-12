/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.toulouse.shared.messages.demandes;

import com.miage.toulouse.shared.messages.Etudiant;

/**
 *
 * @author Mahdi
 */
public abstract class DemandeValidation {
    Long idDemandeConvention;    
    Etudiant etudiant;
    DemandeValidation () {
        this.etudiant = new Etudiant();
    } 
}
