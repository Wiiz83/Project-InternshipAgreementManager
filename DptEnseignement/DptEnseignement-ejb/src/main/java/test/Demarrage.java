/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import controllers.PreconventionControllerRemote;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import repositories.DepartementRepositoryLocal;
import shared.DonnesTest;
import shared.donnees.Departement;

/**
 *
 * @author Mahdi
 */
@Singleton
@Startup

public class Demarrage {
    
    @EJB
    DepartementRepositoryLocal drepo;    
    
    @EJB
PreconventionControllerRemote ctrl;    
    @PostConstruct
    public void init() {
        DonnesTest dt = new DonnesTest();
        for (Departement d : dt.listeDepartements) {
            drepo.insert(d);
        }
        System.out.println(ctrl.obtenirDepartements());
    }
}
