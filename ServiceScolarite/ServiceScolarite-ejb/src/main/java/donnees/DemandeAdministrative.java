/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import miage.iae.projet.shared.donnees.ConfirmationAdministrative;
import miage.iae.projet.shared.messages.demandes.DemandeValidationAdministrative;

/**
 *
 * @author Mahdi
 */
public class DemandeAdministrative {

    public DemandeValidationAdministrative demande;
    public ConfirmationAdministrative confirmation;

    public DemandeAdministrative(DemandeValidationAdministrative demande) {
        this.demande = demande;
    }
}
