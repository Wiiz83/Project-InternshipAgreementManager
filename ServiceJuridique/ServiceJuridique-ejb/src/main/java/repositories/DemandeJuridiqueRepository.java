/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandeJuridique;
import javax.ejb.Singleton;
import shared.repository.KVRepository;

/**
 *
 * @author Mahdi
 */
@Singleton
public class DemandeJuridiqueRepository  extends KVRepository<DemandeJuridique> implements DemandeJuridiqueRepositoryLocal
{

}
