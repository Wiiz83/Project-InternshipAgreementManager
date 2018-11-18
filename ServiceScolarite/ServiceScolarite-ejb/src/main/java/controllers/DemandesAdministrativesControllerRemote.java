/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandeAdministrative;
import java.util.Collection;
import javax.ejb.Remote;
import shared.messages.notifications.ConfirmationValiditeStage;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;

/**
 *
 * @author Mahdi
 */
@Remote
public interface DemandesAdministrativesControllerRemote {
    
    public Collection <DemandeAdministrative> obtenirDemandes();

    public void ajouterDemande(shared.messages.demandes.DemandeValidationAdministrative demande);

    public void annulerDemande(NotificationAnnulationDemandeValidation n);

    public void refuserDemande(Long id, String motif);

    public void accepterDemande(Long id);
}
