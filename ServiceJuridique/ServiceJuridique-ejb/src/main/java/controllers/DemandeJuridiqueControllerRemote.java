/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandeJuridique;
import java.util.Collection;
import javax.ejb.Remote;
import shared.messages.demandes.DemandeValidationJuridique;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;

/**
 *
 * @author Mahdi
 */
@Remote
public interface DemandeJuridiqueControllerRemote {

    /**
     *
     * @return
     */
    public Collection<DemandeJuridique> obtenirDemandes();

    /**
     *
     * @param demande
     */
    public void ajouterDemande(DemandeValidationJuridique demande);

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

    /**
     *
     * @param siret
     * @param nom
     * @return
     */
    public boolean verifierEntreprise(String siret, String nom);

    /**
     *
     * @param id
     * @return
     */
    public boolean verifierResponsabiliteCivile(Long id);
}
