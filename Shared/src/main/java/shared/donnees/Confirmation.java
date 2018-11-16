/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.donnees;

import java.io.Serializable;

/**
 *
 * @author Mahdi
 */
public abstract class Confirmation implements Serializable {
    private boolean valide;
    private String motif;

    public Confirmation() {
        this.valide = true;
    }    

    public Confirmation(boolean valide, String motif) {
        this.valide = valide;
        this.motif = motif;
    }

    public boolean isValide() {
        return valide;
    }

    public String getMotif() {
        return motif;
    }
    
    
    
}
