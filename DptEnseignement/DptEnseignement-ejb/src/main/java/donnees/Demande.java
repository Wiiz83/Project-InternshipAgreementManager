/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import miage.iae.projet.shared.donnees.ConfirmationPedagogique;
import miage.iae.projet.shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author Mahdi
 */
public class Demande {
    public DemandeValidationPedagogique demande;
    public ConfirmationPedagogique confirmation;
    public Boolean validationFinale;    
}
