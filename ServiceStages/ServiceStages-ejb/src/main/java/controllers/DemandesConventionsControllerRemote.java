/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandeConvention;
import java.util.Collection;
import javax.ejb.Remote;
import shared.messages.validations.Validation;

/**
 *
 * @author Mahdi
 */
@Remote
public interface DemandesConventionsControllerRemote {

    void ajouterDemande(shared.messages.demandes.DemandeConventionMessage demande);
    
    void validationAdministrative (shared.messages.validations.ValidationAdministrative va);
    
    void validationPedagogique (shared.messages.validations.ValidationPedagogique vp);
    
    void validationJuridique (shared.messages.validations.ValidationJuridique vj);
    
    boolean estValide(DemandeConvention dc); 

    void archiverDemande(Long id);

    Collection<DemandeConvention> obtenirDemandesEncours();

    Collection<DemandeConvention> obtenirDemandesValidees();

    Collection<DemandeConvention> obtenirDemandesRefusees();

    Collection<DemandeConvention> obtenirDemandesArchivees();  
    
    Validation obtenirVoletInvalide(DemandeConvention dc);
}
