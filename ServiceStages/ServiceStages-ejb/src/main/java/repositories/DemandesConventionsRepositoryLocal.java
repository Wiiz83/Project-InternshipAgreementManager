/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandeConvention;
import java.util.Collection;
import javax.ejb.Local;
import shared.repository.Repository;

/**
 *
 * @author Mahdi
 */
@Local
public interface DemandesConventionsRepositoryLocal extends Repository<DemandeConvention> {

    /**
     *
     * @return
     */
    Collection<DemandeConvention> obtenirDemandesEncours();

    /**
     *
     * @return
     */
    Collection<DemandeConvention> obtenirDemandesValidees();

    /**
     *
     * @return
     */
    Collection<DemandeConvention> obtenirDemandesRefusees();

    /**
     *
     * @return
     */
    Collection<DemandeConvention> obtenirDemandesArchivees();

    /**
     *
     * @param key
     */
    void archiver(Long key);

}
