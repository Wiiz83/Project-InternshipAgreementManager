/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import miage.iae.projet.shared.donnees.ConfirmationJuridique;
import miage.iae.projet.shared.messages.demandes.DemandeValidationJuridique;

/**
 *
 * @author Mahdi
 */
public class DemandeJuridique {

    public DemandeValidationJuridique demande;
    public ConfirmationJuridique confirmation;

    public DemandeJuridique(DemandeValidationJuridique demande) {
        this.demande = demande;
    }
}