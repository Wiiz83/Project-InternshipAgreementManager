/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandePedagogique;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import shared.Repository;
import shared.donnees.Departement;
import shared.donnees.Diplome;
import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.Stage;
import shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author uzanl
 */
@Singleton
public class PreconventionRepository implements PreconventionRepositoryLocal {

    private Map<Long, DemandePedagogique> listePreconventions;
    private Long id;

    @PostConstruct
    public void init() {
        this.id = new Long(0);
        listePreconventions = new HashMap<>();
        System.out.println("PreconventionRepository: Singleton");
        this.test();
    }

    // TESTS
    private void test() {
        Stage s = new Stage(new Date(2018, 10, 10), new Date(2018, 12, 15), new Double(500), "Super stage!");
        Entreprise e = new Entreprise("49646464464", "Air France");
        Diplome d = new Diplome("Master XX", "Informatique", new Departement(""));
        Etudiant etudiant = new Etudiant("TEST", "TEST", "TEST");
        DemandeValidationPedagogique dvp = new DemandeValidationPedagogique(s, e, d, new Long(564), etudiant);
        DemandePedagogique dp = new DemandePedagogique(dvp);
        this.listePreconventions.put(this.id, dp);
    }

    @Override
    public DemandePedagogique get(Long id) {
        return this.listePreconventions.get(id);
    }

    @Override
    public Collection<DemandePedagogique> getAll() {
        return this.listePreconventions.values();
    }

    @Override
    public void insert(DemandePedagogique dp) {
        this.id++; //
        this.listePreconventions.put(dp.getDemande().getIdDemandeConvention(), dp);
    }

    @Override
    public void update(Long id, DemandePedagogique dp) {
        // ne fait rien en pratique car en mémoire, mais on la met au cas où on 
        // décide de persister
    }

    @Override
    public void delete(Long id) {
        this.listePreconventions.remove(id);
    }

    @Override
    public Map<Long, DemandePedagogique> getAllPreconventionsEnCours() {
        Map<Long, DemandePedagogique> listePreconventionsEnCours = new HashMap<>();
        for (Map.Entry<Long, DemandePedagogique> entry : listePreconventions.entrySet()) {
            if (entry.getValue().getConfirmation() == null) {
                listePreconventionsEnCours.put(entry.getKey(), entry.getValue());
            }
        }
        return listePreconventionsEnCours;
    }

    @Override
    public Map<Long, DemandePedagogique> getAllPreconventionsValides() {
        Map<Long, DemandePedagogique> listePreconventionsValides = new HashMap<>();
        for (Map.Entry<Long, DemandePedagogique> entry : listePreconventions.entrySet()) {
            if (entry.getValue().getValidationFinale() == true) {
                listePreconventionsValides.put(entry.getKey(), entry.getValue());
            }
        }
        return listePreconventionsValides;
    }
}
