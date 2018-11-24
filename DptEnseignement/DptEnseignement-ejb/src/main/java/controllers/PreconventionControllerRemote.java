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
     * @return Liste des préconventions en cours
     */
    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours(Long dptKey);

    /**
     *
     * @param dptKey
     * @return Liste des préconventions dont il a été décidé l’établissement de la convention
     */
    public Map<Long, DemandePedagogique> recupererPreconventionsValides(Long dptKey);

    /**
     * Ajoute une demande de validation pédagogique
     * @param demande
     */
    public void ajouterDemande(shared.messages.demandes.DemandeValidationPedagogique demande);

    /**
     * Ajoute une préconvention dont il a été décidé l’établissement de la convention
     * @param cvs
     */
    public void confirmerValidationFinale(ConfirmationValiditeStage cvs);

    /**
     * Annule une demande de validation pédagogique
     * @param n
     */
    public void annulerDemande(NotificationAnnulationDemandeValidation n);

    /**
     * Refuser une demande de validation pédagogique
     * @param id
     * @param motif
     */
    public void refuserDemande(Long id, String motif);

    /**
     * Accepeter une demande de validation pédagogique
     * @param id
     * @param nomTuteur
     */
    public void accepterDemande(Long id, String nomTuteur);

    /**
     * 
     * @return Liste des départements d'enseignement
     */
    Collection<Departement> obtenirDepartements();

    /**
     *
     * @param d
     * @return Diplomes associés à un département d'enseignement
     */
    Collection<Diplome> obtenirDiplomes(Departement d);

}
