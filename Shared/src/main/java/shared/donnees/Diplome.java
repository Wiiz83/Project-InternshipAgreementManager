/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.donnees;

import shared.donnees.Departement;
import java.io.Serializable;

/**
 *
 * @author Mahdi
 */
public class Diplome implements Serializable {

    public String niveau;
    public String intitule;
    public Departement departement;
    
 
    public Diplome(String niveau, String intitule) {
        this.niveau = niveau;
        this.intitule = intitule;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    

}
