/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.Collection;
import javax.ejb.Local;
import shared.opendata.ConventionValidee;

/**
 *
 * @author Mahdi
 */
@Local
public interface ConventionsValideesRepositoryLocal {

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    Collection<ConventionValidee> get(int offset, int limit);

    /**
     *
     * @param c
     */
    void insert (ConventionValidee c);
    
}
