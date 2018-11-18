/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandePedagogique;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;
import shared.repository.KVRepository;

/**
 *
 * @author uzanl
 */
@Singleton
public class PreconventionRepository extends KVRepository<DemandePedagogique> implements PreconventionRepositoryLocal {


 

    @Override
    public Map<Long, DemandePedagogique> getAllPreconventionsEnCours() {
        Map<Long, DemandePedagogique> listePreconventionsEnCours = new HashMap<>();
        for (Map.Entry<Long, DemandePedagogique> entry : kvstore.entrySet()) {
            if (entry.getValue().getValidation() == null) {
                listePreconventionsEnCours.put(entry.getKey(), entry.getValue());
            }
        }
        return listePreconventionsEnCours;
    }

    @Override
    public Map<Long, DemandePedagogique> getAllPreconventionsValides() {
        Map<Long, DemandePedagogique> listePreconventionsValides = new HashMap<>();
        for (Map.Entry<Long, DemandePedagogique> entry : kvstore.entrySet()) {
            if (entry.getValue().getValidationFinale() == true) {
                listePreconventionsValides.put(entry.getKey(), entry.getValue());
            }
        }
        return listePreconventionsValides;
    }
}
