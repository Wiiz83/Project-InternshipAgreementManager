/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandeConvention;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
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
import shared.opendata.ConventionValidee;

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

    /**
     *
     * @param msg
     */
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

    /**
     *
     * @return
     */
    @Override
    public Collection<DemandeConvention> obtenirDemandesEncours() {
        return drepo.obtenirDemandesEncours();
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<DemandeConvention> obtenirDemandesValidees() {
        return drepo.obtenirDemandesValidees();
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<DemandeConvention> obtenirDemandesRefusees() {
        return drepo.obtenirDemandesRefusees();
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<DemandeConvention> obtenirDemandesArchivees() {
        return drepo.obtenirDemandesArchivees();
    }

    /**
     *
     * @param id
     */
    @Override
    public void archiverDemande(Long id) {
        drepo.archiver(id);
    }

    /**
     *
     * @param va
     */
    @Override
    public void validationAdministrative(ValidationAdministrative va) {
        DemandeConvention demande = this.drepo.get(va.getKey());
        demande.setValidationAdministrative(va);
        this.drepo.update(va.getKey(), demande);
        this.verifierEtNotifier(demande);
    }

    /**
     *
     * @param vp
     */
    @Override
    public void validationPedagogique(ValidationPedagogique vp) {
        DemandeConvention demande = this.drepo.get(vp.getKey());
        demande.setValidationPedagogique(vp);
        this.drepo.update(vp.getKey(), demande);
        this.verifierEtNotifier(demande);
    }

    /**
     *
     * @param vj
     */
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
            ConventionsvalideesRESTClient client = new ConventionsvalideesRESTClient();
            // TODO: pas possible de récupérer l'année depuis un string. 
            ConventionValidee c = new ConventionValidee(new Date().getYear(), demande.getDiplome(), demande.getDiplome().getDepartement().getNom(), demande.getEntreprise().getNom(), demande.getStage().getDebut(), demande.getStage().getFin(), demande.getStage().getGratification());
            client.postConventionValidee(c);
        }
        if (Predicats.estRefusee.test(demande)) {
            notificationAnnulationDemande.notifierAnnulation(new NotificationAnnulationDemandeValidation(demande.getKey()));
        }
    }

    /**
     *
     * @param dc
     * @return
     */
    @Override
    public Validation obtenirVoletInvalide(DemandeConvention dc) {
        if (dc.getValidationAdministrative() != null && !dc.getValidationAdministrative().isValide()) {
            return dc.getValidationAdministrative();
        }
        if (dc.getValidationJuridique() != null && !dc.getValidationJuridique().isValide()) {
            return dc.getValidationJuridique();
        }
        if (dc.getValidationPedagogique() != null && !dc.getValidationPedagogique().isValide()) {
            return dc.getValidationPedagogique();
        }
        return null;
    }

    static class ConventionsvalideesRESTClient {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://localhost:8080/OpenDataConventions-web/webresources";

        public ConventionsvalideesRESTClient() {
            client = javax.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI).path("conventionsvalidees");
        }

        public void postConventionValidee(ConventionValidee c) throws ClientErrorException {
            webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(c, javax.ws.rs.core.MediaType.APPLICATION_JSON));
        }

        public void close() {
            client.close();
        }
    }

}
