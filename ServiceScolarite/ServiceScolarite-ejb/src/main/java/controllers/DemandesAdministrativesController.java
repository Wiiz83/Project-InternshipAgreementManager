/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandeAdministrative;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.DemandesAdministrativesRepositoryLocal;
import senders.ValidationAdministrativeSender;
import shared.messages.demandes.DemandeValidationAdministrative;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;
import shared.messages.validations.ValidationAdministrative;

/**
 *
 * @author Mahdi
 */
@Stateless
public class DemandesAdministrativesController implements DemandesAdministrativesControllerRemote {

    @EJB
    ValidationAdministrativeSender validationAdministrativeSender;

    @EJB
    DemandesAdministrativesRepositoryLocal repo;

    @Override
    public void ajouterDemande(DemandeValidationAdministrative demande) {
        repo.insert(new DemandeAdministrative(demande));
    }

    @Override
    public void annulerDemande(NotificationAnnulationDemandeValidation n) {
        repo.delete(n.getIdDemandeConvention());
    }

    @Override
    public void refuserDemande(Long id, String motif) {
        DemandeAdministrative dp = repo.get(id);
        dp.setValidation(new ValidationAdministrative(id, false, motif));
        repo.update(id, dp);
        ValidationAdministrative msg = new ValidationAdministrative(id, false, motif);
        validationAdministrativeSender.envoyerValidationAdministrative(msg);
    }

    @Override
    public void accepterDemande(Long id) {
        DemandeAdministrative dp = repo.get(id);
        dp.setValidation(new ValidationAdministrative(id));
        repo.update(id, dp);
        ValidationAdministrative msg = new ValidationAdministrative(id);
        validationAdministrativeSender.envoyerValidationAdministrative(msg);
    }

    @Override
    public Collection<DemandeAdministrative> obtenirDemandes() {
        return this.repo.getAll();
    }
}
