/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages.demandes;

import miage.iae.projet.shared.messages.Diplome;
import miage.iae.projet.shared.messages.Etudiant;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationAdministrative extends DemandeValidation{
    public Diplome diplome;
    DemandeValidationAdministrative() {
        super();
        this.diplome= new Diplome();
    }

    public DemandeValidationAdministrative(Diplome diplome) {
        this.diplome = diplome;
    }

    public DemandeValidationAdministrative(Diplome diplome, Long idDemandeConvention, Etudiant etudiant) {
        super(idDemandeConvention, etudiant);
        this.diplome = diplome;
    }

    @Override
    public String toString() {
        return "DemandeValidationAdministrative{" + "diplome=" + diplome + '}' + super.toString();
    }
    
    
    
}
