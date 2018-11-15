/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import miage.iae.projet.shared.donnees.Departement;

/**
 *
 * @author uzanl
 */
public class DepartementRepository {
    
    ArrayList<Departement> listeDepartements;

    public ArrayList<Departement> getAllDepartements(){
        return listeDepartements;
    }

}
