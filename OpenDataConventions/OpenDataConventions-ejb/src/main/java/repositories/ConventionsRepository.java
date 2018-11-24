/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import shared.opendata.ConventionValidee;

/**
 *
 * @author Mahdi
 */
@Singleton
public class ConventionsRepository implements ConventionsValideesRepositoryLocal {
    private final ArrayList<ConventionValidee> liste = new ArrayList<>();
    
    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public Collection<ConventionValidee> get(int offset, int limit) {
        return liste.stream().skip(offset).limit(limit).collect(Collectors.toSet());
    }

    /**
     *
     * @param c
     */
    @Override
    public void insert(ConventionValidee c) {
        liste.add(c);
    }

}
