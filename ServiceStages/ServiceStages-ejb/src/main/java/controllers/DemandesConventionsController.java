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
import senders.ValidationAdministrativeSender;
import senders.ValidationJuridiqueSender;
import senders.ValidationPedagogiqueSender;
import shared.messages.demandes.DemandeConventionMessage;
import shared.messages.demandes.DemandeValidationAdministrative;
import shared.messages.demandes.DemandeValidationJuridique;
import shared.messages.demandes.DemandeValidationPedagogique;
import repositories.DemandesConventionsRepositoryLocal;
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
    ValidationAdministrativeSender validationAdministrativeSender;

    @EJB
    ValidationPedagogiqueSender validationPedagogiqueSender;

    @EJB
    ValidationJuridiqueSender validationJuridiqueSender;


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
        return drepo.obtenirDemandesRefusees();
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
        drepo.delete(id);
    }

    @Override
    public void validationAdministrative(ValidationAdministrative va) {        
       this.drepo.get(va.getKey()).setValidationAdministrative(va);
       if( this.drepo.estValide(va.getKey())) {
           // TODO 
       }
    }

    @Override
    public void validationPedagogique(ValidationPedagogique vp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validationJuridique(ValidationJuridique vj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean estValide (Long key) {
       return this.drepo.estValide(key);
    }
}
