/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandeJuridique;
import javax.ejb.Local;
import shared.repository.Repository;

/**
 *
 * @author Mahdi
 */
@Local
public interface DemandeJuridiqueRepositoryLocal extends Repository<DemandeJuridique> {
    
}
