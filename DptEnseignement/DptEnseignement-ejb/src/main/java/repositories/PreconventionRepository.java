/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandePedagogique;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author uzanl
 */
public class PreconventionRepository {
    
    private Map<Long, DemandePedagogique> listePreconventions = new HashMap<>();
    private Long id = new Long(0);

    public void insertNewPreconvention(DemandePedagogique dp){
        this.id++;
        this.listePreconventions.put(this.id, dp);
    }
    
    public Map<Long, DemandePedagogique> getAllPreconventionsEnCours(){
        Map<Long, DemandePedagogique> listePreconventionsEnCours = new HashMap<>();
        for(Map.Entry<Long, DemandePedagogique> entry : listePreconventions.entrySet()) {
            if(entry.getValue().confirmation == null){
                listePreconventionsEnCours.put(entry.getKey(), entry.getValue());
            }
        }
        return listePreconventionsEnCours;
    }
    
    public Map<Long, DemandePedagogique> getAllPreconventionsValides(){
        Map<Long, DemandePedagogique> listePreconventionsValides = new HashMap<>();
        for(Map.Entry<Long, DemandePedagogique> entry : listePreconventions.entrySet()) {
            if(entry.getValue().validationFinale == true){
                listePreconventionsValides.put(entry.getKey(), entry.getValue());
            }
        }
        return listePreconventionsValides;
    }
    
}
