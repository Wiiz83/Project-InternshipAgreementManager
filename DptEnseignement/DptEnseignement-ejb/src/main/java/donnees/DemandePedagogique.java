/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import shared.donnees.ConfirmationPedagogique;
import shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author Mahdi
 */
public class DemandePedagogique {
    public DemandeValidationPedagogique demande;
    public ConfirmationPedagogique confirmation;
    public Boolean validationFinale;    

    public DemandePedagogique(DemandeValidationPedagogique demande) {
        this.demande = demande;
    }
    
}
