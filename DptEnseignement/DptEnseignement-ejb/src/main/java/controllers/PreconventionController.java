/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandePedagogique;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.PreconventionRepositoryLocal;
import senders.ValidationPedagogiqueSender;
import shared.donnees.ConfirmationPedagogique;
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

    @Override
    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours() {
        // APPEL JMS POUR RECUPERATION DE NOUVELLES PRECONV

        // STOCKAGE EN MEMOIRE DE CES NOUVELLES PRECONV
        // RECUPERATION DES DEMANDES EN MEMOIRE
        Map<Long, DemandePedagogique> listePEC = repo.getAllPreconventionsEnCours();

        // RENVOI DE LA LISTE DES PRECONV
        return listePEC;
    }

    /*
        Traitement des messages JMS reçus
     */
    @Override
    public void ajouterDemande(shared.messages.demandes.DemandeValidationPedagogique demande) {
        repo.insert(new DemandePedagogique(demande));
    }

    @Override
    public void confirmerValidationFinale(shared.messages.notifications.ConfirmationValiditeStage cvs) {
        DemandePedagogique dp = repo.get(cvs.getIdDemandeConvention());
        dp.setValidationFinale(true);
    }

    @Override
    public void annulerDemande(shared.messages.notifications.NotificationAnnulationDemandeValidation n) {
        repo.delete(n.getIdDemandeConvention());
    }

    /*
        Actions utilisateur : maj BD + envoi message JMS
     */
    @Override
    public void accepterDemande(Long id, String nomTuteur) {
        DemandePedagogique dp = repo.get(id);
        dp.setConfirmation(new ConfirmationPedagogique(nomTuteur));
        repo.update(id, dp);
        ValidationPedagogique msg = new ValidationPedagogique(nomTuteur, id, true, null);
        vpSender.envoyerValidationPedagogique(msg);
    }

    @Override
    public void refuserDemande(Long id, String motif) {
        DemandePedagogique dp = repo.get(id);
        dp.setConfirmation(new ConfirmationPedagogique(false, motif));
        repo.update(id, dp);
        ValidationPedagogique msg = new ValidationPedagogique(null, id, true, motif);
        vpSender.envoyerValidationPedagogique(msg);
    }
}
