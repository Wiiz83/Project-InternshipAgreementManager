/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandePedagogique;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.PreconventionRepository;

/**
 *
 * @author uzanl
 */
@Stateless
public class PreconventionController implements PreconventionControllerLocal {

    PreconventionRepository repo = new PreconventionRepository();

    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours() {
        Map<Long, DemandePedagogique> listePEC = repo.getAllPreconventionsEnCours();
        return listePEC;
    }
}
