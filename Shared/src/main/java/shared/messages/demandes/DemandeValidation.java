/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.demandes;

import shared.donnees.Etudiant;
import java.io.Serializable;

/**
 *
 * @author Mahdi
 */
public abstract class DemandeValidation  implements Serializable{
    int idDemandeConvention;    
    Etudiant etudiant;
    DemandeValidation () {
        this.etudiant = new Etudiant();
    } 

    public DemandeValidation(int idDemandeConvention, Etudiant etudiant) {
        this.idDemandeConvention = idDemandeConvention;
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "DemandeValidation{" + "idDemandeConvention=" + idDemandeConvention + ", etudiant=" + etudiant + '}';
    }
    
}
