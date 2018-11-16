/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Singleton;
import shared.Repository;
import shared.donnees.Departement;

/**
 *
 * @author uzanl
 */
//@Singleton
public class DepartementRepository  implements Repository<Departement>{
    
    ArrayList<Departement> listeDepartements = new ArrayList<>();
    
    // TESTS
    public DepartementRepository(){
        Departement d = new Departement("Informatique");
        Departement d1 = new Departement("Études du monde anglophone");
        Departement d2 = new Departement("Mathématiques");
        Departement d3 = new Departement("Activités Physiques");
        Departement d4 = new Departement("Langues et Civilisations");
        listeDepartements.add(d);
        listeDepartements.add(d1);           
        listeDepartements.add(d2); 
        listeDepartements.add(d3); 
        listeDepartements.add(d4); 
    }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Long id, Departement dp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
