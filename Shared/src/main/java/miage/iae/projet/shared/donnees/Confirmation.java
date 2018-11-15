/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.donnees;

/**
 *
 * @author Mahdi
 */
public abstract class Confirmation {
    public boolean valide;
    public String motif;

    Confirmation() {
        this.valide = true;
    }    

    public Confirmation(String motif) {
        this.valide = false;
        this.motif = motif;
    }
    
}
