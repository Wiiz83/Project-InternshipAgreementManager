/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.donnees;

/**
 *
 * @author Mahdi
 */
public class ConfirmationPedagogique extends Confirmation {
    private String nomTuteur;

    public ConfirmationPedagogique(String nomTuteur) {
        super();
        this.nomTuteur = nomTuteur;
    }    

    public ConfirmationPedagogique(boolean b, String motif) {
        super(b,motif);
    }

    public String getNomTuteur() {
        return nomTuteur;
    }  
    
}
