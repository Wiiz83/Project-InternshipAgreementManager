/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.DepartementRepositoryLocal;
import senders.DemandeConventionMessageSender;
import shared.donnees.Departement;
import shared.donnees.Diplome;
import shared.messages.demandes.DemandeConventionMessage;

/**
 *
 * @author Mahdi
 */
@Stateless
public class DemandesConventionsEtudiantController implements DemandesConventionsEtudiantControllerRemote {

    @EJB
    DemandeConventionMessageSender demandeConventionMessageSender;
    
    @EJB
    DepartementRepositoryLocal dprepo;

    @Override
    public void ajouterDemande(DemandeConventionMessage demande) {
        demandeConventionMessageSender.ajouterDemandeDeConvention(demande);
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
