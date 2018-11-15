/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages.demandes;

import miage.iae.projet.shared.donnees.Diplome;
import miage.iae.projet.shared.donnees.Etudiant;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationAdministrative extends DemandeValidation{
    public Diplome diplome;
   
    public DemandeValidationAdministrative(int idDemandeConvention, Etudiant etudiant, Diplome diplome) {
        super(idDemandeConvention, etudiant);
        this.diplome = diplome;
    }

    @Override
    public String toString() {
        return "DemandeValidationAdministrative{" + "diplome=" + diplome + '}' + super.toString();
    }
    
    
    
}
