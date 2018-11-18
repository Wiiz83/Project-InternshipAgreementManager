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

    private String debut;
    private String fin;
    private Double gratification;
    private String resume;

    public Stage(String debut, String fin, Double gratification, String resume) {
        this.debut = debut;
        this.fin = fin;
        this.gratification = gratification;
        this.resume = resume;
    }

    public String getDebut() {
        return debut;
    }

    public String getFin() {
        return fin;
    }

    public Double getGratification() {
        return gratification;
    }

    public String getResume() {
        return resume;
    }   
    
    @Override
    public String toString() {
        return "Stage{" + "debut=" + debut + ", fin=" + fin + ", gratification=" + gratification + ", sujet=" + resume + '}';
    }
}
