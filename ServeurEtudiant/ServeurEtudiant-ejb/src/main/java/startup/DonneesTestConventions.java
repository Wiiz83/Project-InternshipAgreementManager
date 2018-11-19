/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startup;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import shared.DonnesTest;
import shared.messages.demandes.DemandeConventionMessage;
import controllers.DemandesConventionsEtudiantControllerRemote;

/**
 *
 * @author Mahdi
 */
@Singleton
@Startup
public class DonneesTestConventions {

    @EJB 
    DemandesConventionsEtudiantControllerRemote demandesConventionsControllerRemote; 

    @PostConstruct
    public void init() {
        DonnesTest dt = new DonnesTest();
        for (DemandeConventionMessage dc : dt.demandes) {
            demandesConventionsControllerRemote.ajouterDemande(dc);
        }
    }
}
