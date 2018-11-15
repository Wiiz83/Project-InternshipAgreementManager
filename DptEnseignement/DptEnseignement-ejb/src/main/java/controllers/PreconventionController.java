package controllers;

import donnees.DemandePedagogique;
import java.util.Map;
import repositories.PreconventionRepository;


public class PreconventionController {
    
    PreconventionRepository pr = new PreconventionRepository();
    
    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours() {
        // APPEL JMS POUR RECUPERATION DE NOUVELLES PRECONV

        // STOCKAGE EN MEMOIRE DE CES NOUVELLES PRECONV
        
        // RECUPERATION DES DEMANDES EN MEMOIRE
        Map<Long, DemandePedagogique> listePEC = pr.getAllPreconventionsEnCours();
        
        // RENVOI DE LA LISTE DES PRECONV
        return listePEC;
    }

   

}
