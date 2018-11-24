/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.Collection;
import javax.ejb.Local;
import shared.repository.Repository;
import shared.donnees.Departement;
import shared.donnees.Diplome;

/**
 *
 * @author Mahdi
 */
@Local
public interface DepartementRepositoryLocal extends Repository<Departement> {

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
    Departement get(Long id);

    /**
     *
     * @return
     */
    Collection<Departement> getAll();

    /**
     *
     * @param dp
     */
    void insert(Departement dp);

    /**
     *
     * @param id
     * @param dp
     */
    void update(Long id, Departement dp);

    /**
     *
     * @param d
     * @return
     */
    Collection<Diplome> obtenirDiplomes(Departement d);
}
