/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages.demandes;

import miage.iae.projet.shared.messages.Etudiant;
import java.io.Serializable;

/**
 *
 * @author Mahdi
 */
public abstract class DemandeValidation  implements Serializable{
    Long idDemandeConvention;    
    Etudiant etudiant;
    DemandeValidation () {
        this.etudiant = new Etudiant();
    } 
}
