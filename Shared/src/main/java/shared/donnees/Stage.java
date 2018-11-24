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

    /**
     *
     * @param debut
     * @param fin
     * @param gratification
     * @param resume
     */
    public Stage(String debut, String fin, Double gratification, String resume) {
        this.debut = debut;
        this.fin = fin;
        this.gratification = gratification;
        this.resume = resume;
    }

    /**
     *
     * @return
     */
    public String getDebut() {
        return debut;
    }

    /**
     *
     * @return
     */
    public String getFin() {
        return fin;
    }

    /**
     *
     * @return
     */
    public Double getGratification() {
        return gratification;
    }

    /**
     *
     * @return
     */
    public String getResume() {
        return resume;
    }   
    
    @Override
    public String toString() {
        return "Stage{" + "debut=" + debut + ", fin=" + fin + ", gratification=" + gratification + ", sujet=" + resume + '}';
    }
}
