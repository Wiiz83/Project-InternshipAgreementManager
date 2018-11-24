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

    /**
     *
     * @param demande
     */
    @Override
    public void ajouterDemande(DemandeValidationAdministrative demande) {
        repo.insert(new DemandeAdministrative(demande));
    }

    /**
     *
     * @param n
     */
    @Override
    public void annulerDemande(NotificationAnnulationDemandeValidation n) {
        repo.delete(n.getIdDemandeConvention());
    }

    /**
     *
     * @param id
     * @param motif
     */
    @Override
    public void refuserDemande(Long id, String motif) {
        repo.delete(id);
        ValidationAdministrative msg = new ValidationAdministrative(id, false, motif);
        validationAdministrativeSender.envoyerValidationAdministrative(msg);
    }

    /**
     *
     * @param id
     */
    @Override
    public void accepterDemande(Long id) {
        repo.delete(id);
        ValidationAdministrative msg = new ValidationAdministrative(id);
        validationAdministrativeSender.envoyerValidationAdministrative(msg);
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<DemandeAdministrative> obtenirDemandes() {
        return this.repo.getAll();
    }
}
