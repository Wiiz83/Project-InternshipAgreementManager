/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import donnees.DemandeJuridique;
import fr.miage.toulouse.m2.eai.clientrest.metiersiren.SirenPOJO;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import repositories.DemandeJuridiqueRepositoryLocal;
import senders.ValidationJuridiqueSender;
import shared.messages.demandes.DemandeValidationJuridique;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;
import shared.messages.validations.ValidationJuridique;

/**
 *
 * @author Mahdi
 */
@Stateless
public class DemandeJuridiqueController implements DemandeJuridiqueControllerRemote {

    @EJB
    DemandeJuridiqueRepositoryLocal repo;

    @EJB
    ValidationJuridiqueSender validationJuridiqueSender;

    /**
     *
     * @return
     */
    @Override
    public Collection<DemandeJuridique> obtenirDemandes() {
        return this.repo.getAll();
    }

    /**
     *
     * @param demande
     */
    @Override
    public void ajouterDemande(DemandeValidationJuridique demande) {
        this.repo.insert(new DemandeJuridique(demande));
    }

    /**
     *
     * @param n
     */
    @Override
    public void annulerDemande(NotificationAnnulationDemandeValidation n) {
        this.repo.delete(n.getIdDemandeConvention());
    }

    /**
     *
     * @param id
     * @param motif
     */
    @Override
    public void refuserDemande(Long id, String motif) {
        repo.delete(id);
        ValidationJuridique msg = new ValidationJuridique(id, false, motif);
        validationJuridiqueSender.envoyerValidationJuridique(msg);
    }

    /**
     *
     * @param id
     */
    @Override
    public void accepterDemande(Long id) {
        repo.delete(id);
        ValidationJuridique msg = new ValidationJuridique(id);
        validationJuridiqueSender.envoyerValidationJuridique(msg);
    }

    /**
     *
     * @param siren
     * @param nom
     * @return
     */
    @Override
    public boolean verifierEntreprise(String siren, String nom) {
        Gson gson = new Gson();
        // TOKEN BEARER a récuperer sur INSEE
        String token = "Bearer 87faafeb-b34f-39d4-8cc0-cb9e7a15a8d9";
        // URI Service INSEE
        String uri = "http://data.opendatasoft.com/api/records/1.0/search/?dataset=sirene%40public";

        // a ajuster selon requete voir mode emploi INSEE
        String query = "&lang=fr&rows=1";
        Client client = ClientBuilder.newClient();
        WebTarget wt = client.target(uri + "&q=" + siren + query);

        //WebResource webResource = client.resource(uri + siren + query);
        System.out.println("uri appel: " + uri + "&q=" + siren + query);
        Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        String reponse = response.readEntity(String.class);

        // Convertisseur JSON
        SirenPOJO model = gson.fromJson(reponse, SirenPOJO.class);
        if (response.getStatus() == 200) {
            return model.getRecords().length == 1;
        } else {
            return false; //TODO
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean verifierResponsabiliteCivile(Long id) {
        return true;
    }

}
