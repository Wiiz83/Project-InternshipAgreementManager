/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import senders.DemandeConventionMessageSender;
import shared.donnees.Departement;
import shared.donnees.Diplome;
import shared.messages.demandes.DemandeConventionMessage;

/**
 *
 * @author Mahdi
 */
@Stateless
public class DemandesConventionsController implements DemandesConventionsEtudiantControllerRemote {

    @EJB
    DemandeConventionMessageSender demandeConventionMessageSender;

    @Override
    public void ajouterDemande(DemandeConventionMessage demande) {
        demandeConventionMessageSender.ajouterDemandeDeConvention(demande);
    }

    @Override
    public Collection<Departement> obtenirDepartements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Diplome> obtenirDiplomes(Departement d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
