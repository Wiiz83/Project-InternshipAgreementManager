/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.donnees;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mahdi
 */
public class Stage implements Serializable {

    public Date debut;
    public Date fin;
    public Double gratification;
    public String sujet;

    public Stage() {
    }

    public Stage(Date debut, Date fin, Double gratification, String sujet) {
        this.debut = debut;
        this.fin = fin;
        this.gratification = gratification;
        this.sujet = sujet;
    }
    
    

    @Override
    public String toString() {
        return "Stage{" + "debut=" + debut + ", fin=" + fin + ", gratification=" + gratification + ", sujet=" + sujet + '}';
    }
}
