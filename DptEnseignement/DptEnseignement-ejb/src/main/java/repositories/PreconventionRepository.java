/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandePedagogique;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import shared.donnees.ConfirmationPedagogique;
import shared.donnees.Diplome;
import shared.donnees.Entreprise;
import shared.donnees.Stage;
import shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author uzanl
 */
@Singleton
public class PreconventionRepository {
    
    private Map<Long, DemandePedagogique> listePreconventions ;
    private Long id;
    
    @PostConstruct
    public void init() {
        this.id= new Long(0);
        listePreconventions = new HashMap<>();
        this.test();
    }
    
    // TESTS
    private void test(){
        Stage s = new Stage(new Date(2018, 10, 10), new Date(2018, 12, 15), new Double(500), "Super stage!");
        Entreprise e = new Entreprise("49646464464", "Air France");
        Diplome d = new Diplome("Master 2", "Informatique");
        DemandeValidationPedagogique dvp = new DemandeValidationPedagogique(s, e, d);
        DemandePedagogique dp = new DemandePedagogique(dvp);
        this.listePreconventions.put(this.id, dp);
    }
    

    public void insertNewPreconvention(DemandePedagogique dp){
        this.id++;
        this.listePreconventions.put(this.id, dp);
    }
    
    public void setPreconventionStatutInvalide(Long id, ConfirmationPedagogique c){
        DemandePedagogique dp = listePreconventions.get(id);
        dp.confirmation = c;
    }
    
    public void setPreconventionStatutValide(Long id, ConfirmationPedagogique c){
        
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
