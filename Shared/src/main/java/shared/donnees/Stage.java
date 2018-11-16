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

    private Date debut;
    private Date fin;
    private Double gratification;
    private String resume;

    public Stage(Date debut, Date fin, Double gratification, String resume) {
        this.debut = debut;
        this.fin = fin;
        this.gratification = gratification;
        this.resume = resume;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
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
