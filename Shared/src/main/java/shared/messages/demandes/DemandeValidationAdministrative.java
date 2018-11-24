/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.demandes;

import shared.donnees.Diplome;
import shared.donnees.Etudiant;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationAdministrative extends DemandeValidation{
    private Diplome diplome;
   
    /**
     *
     * @param idDemandeConvention
     * @param etudiant
     * @param diplome
     */
    public DemandeValidationAdministrative(Long idDemandeConvention, Etudiant etudiant, Diplome diplome) {
        super(idDemandeConvention, etudiant);
        this.diplome = diplome;
    }

    @Override
    public String toString() {
        return "DemandeValidationAdministrative{" + "diplome=" + diplome + '}' + super.toString();
    }

    /**
     *
     * @return
     */
    public Diplome getDiplome() {
        return diplome;
    }
    
    
    
    
    
}
