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
public class ConfirmationPedagogique extends Confirmation {
    public String nomTuteur;

    public ConfirmationPedagogique(String nomTuteur) {
        super();
        this.nomTuteur = nomTuteur;
    }    
    
}
