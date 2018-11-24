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

    /**
     *
     * @param id
     */
    void delete(Long id);

    /**
     *
     * @param id
     * @return
     */
    DemandePedagogique get(Long id);

    /**
     *
     * @return
     */
    Collection<DemandePedagogique> getAll();

    /**
     *
     * @param dptKey
     * @return
     */
    Map<Long, DemandePedagogique> getAllPreconventionsEnCours(Long dptKey);

    /**
     *
     * @param dptKey
     * @return
     */
    Map<Long, DemandePedagogique> getAllPreconventionsValides(Long dptKey);

    /**
     *
     * @param dp
     */
    void insert(DemandePedagogique dp);

    /**
     *
     * @param id
     * @param dp
     */
    void update(Long id, DemandePedagogique dp);
    
}
