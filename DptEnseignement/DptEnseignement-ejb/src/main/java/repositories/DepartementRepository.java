/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Singleton;
import shared.repository.Repository;
import shared.donnees.Departement;
import shared.donnees.Diplome;

/**
 *
 * @author uzanl
 */
@Singleton
public class DepartementRepository  implements DepartementRepositoryLocal{
    
    ArrayList<Departement> listeDepartements = new ArrayList<>();
    

    @Override
    public Departement get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Departement> getAll() {
        return listeDepartements;
    }

    @Override
    public void insert(Departement dp) {
        listeDepartements.add(dp);
    }

    @Override
    public void update(Long id, Departement dp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Diplome> obtenirDiplomes(Departement d) {
        return d.getDiplomes();
    }

}
