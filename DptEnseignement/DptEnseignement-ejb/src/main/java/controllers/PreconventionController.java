package controllers;

import donnees.DemandePedagogique;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.PreconventionRepository;

@Stateless

public class PreconventionController {
   // @EJB
    PreconventionRepository pr =new PreconventionRepository(); // cpasbien
    
    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours() {
        // APPEL JMS POUR RECUPERATION DE NOUVELLES PRECONV

        // STOCKAGE EN MEMOIRE DE CES NOUVELLES PRECONV
        
        // RECUPERATION DES DEMANDES EN MEMOIRE
        Map<Long, DemandePedagogique> listePEC = pr.getAllPreconventionsEnCours();
        
        // RENVOI DE LA LISTE DES PRECONV
        return listePEC;
    }
    
    public void ajouterDemande (shared.messages.demandes.DemandeValidationPedagogique demande) {
        pr.insertNewPreconvention(new DemandePedagogique(demande));
    }

   

}
