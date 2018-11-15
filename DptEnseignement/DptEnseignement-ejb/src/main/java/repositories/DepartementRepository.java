/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import javax.ejb.Singleton;
import shared.donnees.Departement;

/**
 *
 * @author uzanl
 */
//@Singleton
public class DepartementRepository {
    
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

    public ArrayList<Departement> getAllDepartements(){
        return listeDepartements;
    }

}
