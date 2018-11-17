/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandePedagogique;
import java.util.Map;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author uzanl
 */
@Remote
public interface PreconventionControllerLocal {
    
    public Map<Long, DemandePedagogique> recupererPreconventionsEnCours();
    
}
