/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.ejb.Singleton;
import shared.opendata.ConventionValidee;

/**
 *
 * @author Mahdi
 */
@Singleton
public class ConventionsRepository implements ConventionsRepositoryLocal {
    private final ArrayList<ConventionValidee> liste = new ArrayList<>();
    
    @Override
    public Collection<ConventionValidee> get(int offset, int limit) {
        return liste.stream().skip(offset).limit(limit).collect(Collectors.toSet());
    }

    @Override
    public void insert(ConventionValidee c) {
        liste.add(c);
    }

}
