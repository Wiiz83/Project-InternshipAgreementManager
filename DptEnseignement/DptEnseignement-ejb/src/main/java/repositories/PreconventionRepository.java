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
import miage.iae.projet.shared.donnees.ConfirmationPedagogique;
import miage.iae.projet.shared.donnees.Diplome;
import miage.iae.projet.shared.donnees.Entreprise;
import miage.iae.projet.shared.donnees.Stage;
import miage.iae.projet.shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author uzanl
 */
public class PreconventionRepository {
    
    private Map<Long, DemandePedagogique> listePreconventions = new HashMap<>();
    private Long id = new Long(0);
    
    // TESTS
    public PreconventionRepository(){
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
