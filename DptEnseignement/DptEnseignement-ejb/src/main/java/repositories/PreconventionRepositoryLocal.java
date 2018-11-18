/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandePedagogique;
import java.util.Collection;
import java.util.Map;
import javax.ejb.Local;
import shared.repository.Repository;

/**
 *
 * @author Mahdi
 */
@Local
public interface PreconventionRepositoryLocal extends Repository<DemandePedagogique> {

    void delete(Long id);

    DemandePedagogique get(Long id);

    Collection<DemandePedagogique> getAll();

    Map<Long, DemandePedagogique> getAllPreconventionsEnCours();

    Map<Long, DemandePedagogique> getAllPreconventionsValides();

    void insert(DemandePedagogique dp);

    void update(Long id, DemandePedagogique dp);
    
}
