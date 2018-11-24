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

    @EJB
    ValidationPedagogiqueSender vpSender;

    @EJB
    DepartementRepositoryLocal dprepo;

    /*
        Traitement des messages JMS reçus
     */

    @Override
    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours(Long dptKey) {
        Map<Long, DemandePedagogique> listePEC = repo.getAllPreconventionsEnCours(dptKey);
        return listePEC;
    }


    @Override
    public Map<Long, DemandePedagogique> recupererPreconventionsValides(Long dptKey) {
        return this.repo.getAllPreconventionsValides(dptKey);
    }

    @Override
    public void ajouterDemande(shared.messages.demandes.DemandeValidationPedagogique demande) {
        repo.insert(new DemandePedagogique(demande));
    }

    @Override
    public void confirmerValidationFinale(shared.messages.notifications.ConfirmationValiditeStage cvs) {
        DemandePedagogique dp = repo.get(cvs.getIdDemandeConvention());
        dp.setValidationFinale(true);
        repo.update(cvs.getIdDemandeConvention(), dp);
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
        ValidationPedagogique msg = new ValidationPedagogique(id, nomTuteur);
        dp.setValidation(msg);
        repo.update(id, dp);
        vpSender.envoyerValidationPedagogique(msg);
    }

    @Override
    public void refuserDemande(Long id, String motif) {
        DemandePedagogique dp = repo.get(id);
        ValidationPedagogique msg = new ValidationPedagogique(id, false, motif);
        dp.setValidation(msg);
        repo.update(id, dp);
        vpSender.envoyerValidationPedagogique(msg);
    }

    @Override
    public Collection<Departement> obtenirDepartements() {
        return dprepo.getAll();
    }


    @Override
    public Collection<Diplome> obtenirDiplomes(Departement d) {
        return dprepo.obtenirDiplomes(d);
    }

}
