/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandeAdministrative;
import java.util.Collection;
import javax.ejb.Remote;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;

/**
 *
 * @author Mahdi
 */
@Remote
public interface DemandesAdministrativesControllerRemote {
    
    /**
     *
     * @return
     */
    public Collection <DemandeAdministrative> obtenirDemandes();

    /**
     *
     * @param demande
     */
    public void ajouterDemande(shared.messages.demandes.DemandeValidationAdministrative demande);

    /**
     *
     * @param n
     */
    public void annulerDemande(NotificationAnnulationDemandeValidation n);

    /**
     *
     * @param id
     * @param motif
     */
    public void refuserDemande(Long id, String motif);

    /**
     *
     * @param id
     */
    public void accepterDemande(Long id);
}
