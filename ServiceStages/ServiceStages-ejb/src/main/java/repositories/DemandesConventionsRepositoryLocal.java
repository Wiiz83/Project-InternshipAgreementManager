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

    Collection<DemandeConvention> obtenirDemandesEncours();

    Collection<DemandeConvention> obtenirDemandesValidees();

    Collection<DemandeConvention> obtenirDemandesRefusees();

    Collection<DemandeConvention> obtenirDemandesArchivees();

    void archiver(Long key);

    boolean estValide(Long key);
}
