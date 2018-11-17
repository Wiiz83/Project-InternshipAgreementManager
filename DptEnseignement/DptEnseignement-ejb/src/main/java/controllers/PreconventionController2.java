package controllers;

import donnees.DemandePedagogique;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.PreconventionRepository;
import shared.donnees.ConfirmationPedagogique;
import shared.messages.validations.ValidationPedagogique;

@Stateless
public class PreconventionController2 {
    // @EJB

    PreconventionRepository repo = new PreconventionRepository(); // cpasbien

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
    public void ajouterDemande(shared.messages.demandes.DemandeValidationPedagogique demande) {
        repo.insert(new DemandePedagogique(demande));
    }

    public void confirmerValidationFinale(shared.messages.notifications.ConfirmationValiditeStage cvs) {
        DemandePedagogique dp = repo.get(cvs.getIdDemandeConvention());
        dp.setValidationFinale (true);
    }

    public void annulerDemande(shared.messages.notifications.NotificationAnnulationDemandeValidation n) {
        repo.delete(n.getIdDemandeConvention());
    }
    /*
        Actions utilisateur : maj BD + envoi message JMS
    */
    public void accepterDemande(Long id, String nomTuteur) {
        DemandePedagogique dp = repo.get(id);
        dp.setConfirmation ( new ConfirmationPedagogique(nomTuteur));
        repo.update(id, dp);
        ValidationPedagogique msg = new ValidationPedagogique(nomTuteur, id, true, null);
        //envoyer msg par jms
    }

    public void refuserDemande(Long id, String motif) {
        DemandePedagogique dp = repo.get(id);
        dp.setConfirmation( new ConfirmationPedagogique(false, motif));
        repo.update(id, dp);
        ValidationPedagogique msg = new ValidationPedagogique(null, id, true, motif);
        //envoyer msg par jms
    }

}
