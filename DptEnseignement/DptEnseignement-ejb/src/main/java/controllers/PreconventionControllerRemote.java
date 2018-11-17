/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandePedagogique;
import java.util.Map;
import javax.ejb.Local;
import javax.ejb.Remote;
import shared.messages.notifications.ConfirmationValiditeStage;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;

/**
 *
 * @author uzanl
 */
@Remote
public interface PreconventionControllerRemote {
    
    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours();
    
    public void ajouterDemande(shared.messages.demandes.DemandeValidationPedagogique demande);

    public void confirmerValidationFinale(ConfirmationValiditeStage cvs);

    public void annulerDemande(NotificationAnnulationDemandeValidation n);

    public void refuserDemande(Long id, String motif);

    public void accepterDemande(Long id, String nomTuteur);
    
}
