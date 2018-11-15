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
public class DemandeConvention implements Serializable {
    public int id;
    public Etudiant etudiant;
    public Diplome diplome;
    public ResponsabiliteCivile responsabiliteCivile;
    public Stage stage;
    public Entreprise entreprise;
    
    public ConfirmationJuridique confirmationJuridique;
    public ConfirmationPedagogique confirmationPedagogique;
    public ConfirmationAdministrative confirmationAdministrative;
    
    public DemandeConvention(Etudiant etudiant, Diplome diplome, ResponsabiliteCivile responsabiliteCivile, Stage stage, Entreprise entreprise) {
        this.etudiant = etudiant;
        this.diplome = diplome;
        this.responsabiliteCivile = responsabiliteCivile;
        this.stage = stage;
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "DemandeConvention{" + "etudiant=" + etudiant + ", diplome=" + diplome + ", responsabiliteCivile=" + responsabiliteCivile + ", stage=" + stage + ", entreprise=" + entreprise + '}';
    }
    
}
