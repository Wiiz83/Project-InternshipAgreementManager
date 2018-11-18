/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import senders.DemandeConventionMessageSender;
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

}
