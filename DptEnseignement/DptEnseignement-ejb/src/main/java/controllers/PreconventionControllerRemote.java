/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandePedagogique;
import java.util.Collection;
import java.util.Map;
import javax.ejb.Remote;
import shared.donnees.Departement;
import shared.donnees.Diplome;
import shared.messages.notifications.ConfirmationValiditeStage;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;

/**
 *
 * @author uzanl
 */
@Remote
public interface PreconventionControllerRemote {

    /**
     *
     * @param dptKey
     * @return
     */
    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours(Long dptKey);

    /**
     *
     * @param dptKey
     * @return
     */
    public Map<Long, DemandePedagogique> recupererPreconventionsValides(Long dptKey);

    /**
     *
     * @param demande
     */
    public void ajouterDemande(shared.messages.demandes.DemandeValidationPedagogique demande);

    /**
     *
     * @param cvs
     */
    public void confirmerValidationFinale(ConfirmationValiditeStage cvs);

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
     * @param nomTuteur
     */
    public void accepterDemande(Long id, String nomTuteur);

    /**
     *
     * @return
     */
    Collection<Departement> obtenirDepartements();

    /**
     *
     * @param d
     * @return
     */
    Collection<Diplome> obtenirDiplomes(Departement d);

}
