/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandeConvention;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import senders.DemandeValidationAdministrativeSender;
import senders.DemandeValidationJuridiqueSender;
import senders.DemandeValidationPedagogiqueSender;
import shared.messages.demandes.DemandeConventionMessage;
import shared.messages.demandes.DemandeValidationAdministrative;
import shared.messages.demandes.DemandeValidationJuridique;
import shared.messages.demandes.DemandeValidationPedagogique;
import repositories.DemandesConventionsRepositoryLocal;
import repositories.Predicats;
import senders.ConfirmationValiditeStageSender;
import senders.NotificationAnnulationDemandeSender;
import shared.messages.notifications.ConfirmationValiditeStage;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;
import shared.messages.validations.Validation;
import shared.messages.validations.ValidationAdministrative;
import shared.messages.validations.ValidationJuridique;
import shared.messages.validations.ValidationPedagogique;

/**
 *
 * @author Mahdi
 */
@Stateless
public class DemandesConventionsController implements DemandesConventionsControllerRemote {

    @EJB
    DemandeValidationAdministrativeSender validationAdministrativeSender;

    @EJB
    DemandeValidationPedagogiqueSender validationPedagogiqueSender;

    @EJB
    DemandeValidationJuridiqueSender validationJuridiqueSender;

    @EJB
    ConfirmationValiditeStageSender confirmationValiditeStageSender;
    
    @EJB
    NotificationAnnulationDemandeSender notificationAnnulationDemande;

    @EJB
    DemandesConventionsRepositoryLocal drepo;

    @Override
    public void ajouterDemande(DemandeConventionMessage msg) {
        DemandeConvention demande = new DemandeConvention(msg.getEtudiant(), msg.getDiplome(), msg.getResponsabiliteCivile(), msg.getStage(), msg.getEntreprise());
        drepo.insert(demande);

        DemandeValidationAdministrative dva = new DemandeValidationAdministrative(demande.getKey(), demande.getEtudiant(), demande.getDiplome());
        validationAdministrativeSender.demanderValidationAdministrative(dva);

        DemandeValidationPedagogique dvop = new DemandeValidationPedagogique(demande.getStage(), demande.getEntreprise(), demande.getDiplome(), demande.getKey(), demande.getEtudiant());
        validationPedagogiqueSender.demanderValidationPedagogique(dvop);

        DemandeValidationJuridique dvj = new DemandeValidationJuridique(demande.getKey(), demande.getResponsabiliteCivile(), demande.getStage(), demande.getEntreprise(), demande.getEtudiant());
        validationJuridiqueSender.demanderValidationJuridique(dvj);
    }

    @Override
    public Collection<DemandeConvention> obtenirDemandesEncours() {
        return drepo.obtenirDemandesEncours();
    }

    @Override
    public Collection<DemandeConvention> obtenirDemandesValidees() {
        return drepo.obtenirDemandesValidees();
    }

    @Override
    public Collection<DemandeConvention> obtenirDemandesRefusees() {
        return drepo.obtenirDemandesRefusees();
    }

    @Override
    public Collection<DemandeConvention> obtenirDemandesArchivees() {
        return drepo.obtenirDemandesArchivees();
    }

    @Override
    public void archiverDemande(Long id) {
        drepo.archiver(id);
    }

    @Override
    public void validationAdministrative(ValidationAdministrative va) {
        DemandeConvention demande = this.drepo.get(va.getKey());
        demande.setValidationAdministrative(va);
        this.drepo.update(va.getKey(), demande);
        this.verifierEtNotifier(demande);
    }

    @Override
    public void validationPedagogique(ValidationPedagogique vp) {
        DemandeConvention demande = this.drepo.get(vp.getKey());
        demande.setValidationPedagogique(vp);
        this.drepo.update(vp.getKey(), demande);
        this.verifierEtNotifier(demande);
    }

    @Override
    public void validationJuridique(ValidationJuridique vj) {
        DemandeConvention demande = this.drepo.get(vj.getKey());
        demande.setValidationJuridique(vj);
        this.drepo.update(vj.getKey(), demande);
        this.verifierEtNotifier(demande);
    }

    private void verifierEtNotifier(DemandeConvention demande) {
        if (Predicats.estValidee.test(demande)) {
            this.confirmationValiditeStageSender.demanderConfirmerValiditeStage(new ConfirmationValiditeStage(demande.getKey()));
        }
        if (Predicats.estRefusee.test(demande)) {
            notificationAnnulationDemande.notifierAnnulation(new NotificationAnnulationDemandeValidation(demande.getKey()));      
        }
    }
/*
    @Override
    public boolean estValide(DemandeConvention dc) {
        return Predicats.estValidee.test(dc);
    }
*/
    
    @Override
    public Validation obtenirVoletInvalide(DemandeConvention dc) {
        if (dc.getValidationAdministrative()!=null &&!dc.getValidationAdministrative().isValide())
            return dc.getValidationAdministrative();
        if (dc.getValidationJuridique()!=null &&!dc.getValidationJuridique().isValide())
            return dc.getValidationJuridique();
        if (dc.getValidationPedagogique()!=null &&!dc.getValidationPedagogique().isValide())
            return dc.getValidationPedagogique();
        return null;                    
    }

    
    
    
}
