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

    void delete(Long id);

    Departement get(Long id);

    Collection<Departement> getAll();

    void insert(Departement dp);

    void update(Long id, Departement dp);

    Collection<Diplome> obtenirDiplomes(Departement d);

    public Collection<Diplome> obtenirTousLesDiplomes();
}
