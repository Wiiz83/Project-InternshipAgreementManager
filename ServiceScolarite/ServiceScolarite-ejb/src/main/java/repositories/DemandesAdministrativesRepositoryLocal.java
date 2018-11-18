/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandeAdministrative;
import javax.ejb.Local;
import shared.messages.demandes.DemandeValidationAdministrative;
import shared.repository.Repository;

/**
 *
 * @author Mahdi
 */
@Local
public interface DemandesAdministrativesRepositoryLocal  extends Repository<DemandeAdministrative>{
    
}
