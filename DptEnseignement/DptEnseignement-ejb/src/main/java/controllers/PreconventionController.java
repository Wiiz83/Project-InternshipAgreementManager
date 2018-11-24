/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandePedagogique;
import java.util.Collection;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.DepartementRepositoryLocal;
import repositories.PreconventionRepositoryLocal;
import senders.ValidationPedagogiqueSender;
import shared.donnees.Departement;
import shared.donnees.Diplome;
import shared.messages.validations.ValidationPedagogique;

/**
 *
 * @author uzanl
 */
@Stateless
public class PreconventionController implements PreconventionControllerRemote {

    @EJB
    PreconventionRepositoryLocal repo;

    // TODO: Tester l'injection
    @EJB
    ValidationPedagogiqueSender vpSender;

    @EJB
    DepartementRepositoryLocal dprepo;

    /**
     *
     * @param dptKey
     * @return
     */
    @Override
    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours(Long dptKey) {
        // APPEL JMS POUR RECUPERATION DE NOUVELLES PRECONV

        // STOCKAGE EN MEMOIRE DE CES NOUVELLES PRECONV
        // RECUPERATION DES DEMANDES EN MEMOIRE
        Map<Long, DemandePedagogique> listePEC = repo.getAllPreconventionsEnCours(dptKey);

        // RENVOI DE LA LISTE DES PRECONV
        return listePEC;
    }

    /**
     *
     * @param dptKey
     * @return
     */
    @Override
    public Map<Long, DemandePedagogique> recupererPreconventionsValides(Long dptKey) {
        return this.repo.getAllPreconventionsValides(dptKey);
    }

    /*
        Traitement des messages JMS reçus
     */

    /**
     *
     * @param demande
     */

    @Override
    public void ajouterDemande(shared.messages.demandes.DemandeValidationPedagogique demande) {
        repo.insert(new DemandePedagogique(demande));
    }

    /**
     *
     * @param cvs
     */
    @Override
    public void confirmerValidationFinale(shared.messages.notifications.ConfirmationValiditeStage cvs) {
        DemandePedagogique dp = repo.get(cvs.getIdDemandeConvention());
        dp.setValidationFinale(true);
        repo.update(cvs.getIdDemandeConvention(), dp);
    }

    /**
     *
     * @param n
     */
    @Override
    public void annulerDemande(shared.messages.notifications.NotificationAnnulationDemandeValidation n) {
        repo.delete(n.getIdDemandeConvention());
    }

    /*
        Actions utilisateur : maj BD + envoi message JMS
     */

    /**
     *
     * @param id
     * @param nomTuteur
     */

    @Override
    public void accepterDemande(Long id, String nomTuteur) {
        DemandePedagogique dp = repo.get(id);
        ValidationPedagogique msg = new ValidationPedagogique(id, nomTuteur);
        dp.setValidation(msg);
        repo.update(id, dp);
        vpSender.envoyerValidationPedagogique(msg);
    }

    /**
     *
     * @param id
     * @param motif
     */
    @Override
    public void refuserDemande(Long id, String motif) {
        DemandePedagogique dp = repo.get(id);
        ValidationPedagogique msg = new ValidationPedagogique(id, false, motif);
        dp.setValidation(msg);
        repo.update(id, dp);
        vpSender.envoyerValidationPedagogique(msg);
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<Departement> obtenirDepartements() {
        return dprepo.getAll();
    }

    /**
     *
     * @param d
     * @return
     */
    @Override
    public Collection<Diplome> obtenirDiplomes(Departement d) {
        return dprepo.obtenirDiplomes(d);
    }

}
