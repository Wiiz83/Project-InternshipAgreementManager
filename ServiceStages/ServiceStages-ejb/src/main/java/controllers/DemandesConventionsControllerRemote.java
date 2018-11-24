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

    /**
     *
     * @param demande
     */
    void ajouterDemande(shared.messages.demandes.DemandeConventionMessage demande);

    /**
     *
     * @param va
     */
    void validationAdministrative(shared.messages.validations.ValidationAdministrative va);

    /**
     *
     * @param vp
     */
    void validationPedagogique(shared.messages.validations.ValidationPedagogique vp);

    /**
     *
     * @param vj
     */
    void validationJuridique(shared.messages.validations.ValidationJuridique vj);

    /**
     *
     * @param id
     */
    void archiverDemande(Long id);

    /**
     *
     * @return
     */
    Collection<DemandeConvention> obtenirDemandesEncours();

    /**
     *
     * @return
     */
    Collection<DemandeConvention> obtenirDemandesValidees();

    /**
     *
     * @return
     */
    Collection<DemandeConvention> obtenirDemandesRefusees();

    /**
     *
     * @return
     */
    Collection<DemandeConvention> obtenirDemandesArchivees();

    /**
     *
     * @param dc
     * @return
     */
    Validation obtenirVoletInvalide(DemandeConvention dc);
    //    boolean estValide(DemandeConvention dc); 
}
