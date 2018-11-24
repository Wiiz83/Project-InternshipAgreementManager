/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import java.io.Serializable;
import shared.donnees.Diplome;
import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.HasKey;
import shared.donnees.ResponsabiliteCivile;
import shared.donnees.Stage;
import shared.messages.validations.ValidationAdministrative;
import shared.messages.validations.ValidationJuridique;
import shared.messages.validations.ValidationPedagogique;

/**
 *
 * @author Mahdi
 */
public class DemandeConvention implements Serializable, HasKey {
    private Long id;
   
    private Etudiant etudiant;
    private Diplome diplome;
    private ResponsabiliteCivile responsabiliteCivile;
    private Stage stage;
    private Entreprise entreprise;
    
    private ValidationJuridique validationJuridique;
    private ValidationPedagogique validationPedagogique;
    private ValidationAdministrative validationAdministrative;

    /**
     *
     * @return
     */
    public ValidationJuridique getValidationJuridique() {
        return validationJuridique;
    }

    /**
     *
     * @param validationJuridique
     */
    public void setValidationJuridique(ValidationJuridique validationJuridique) {
        this.validationJuridique = validationJuridique;
    }

    /**
     *
     * @return
     */
    public ValidationPedagogique getValidationPedagogique() {
        return validationPedagogique;
    }

    /**
     *
     * @param validationPedagogique
     */
    public void setValidationPedagogique(ValidationPedagogique validationPedagogique) {
        this.validationPedagogique = validationPedagogique;
    }

    /**
     *
     * @return
     */
    public ValidationAdministrative getValidationAdministrative() {
        return validationAdministrative;
    }

    /**
     *
     * @param validationAdministrative
     */
    public void setValidationAdministrative(ValidationAdministrative validationAdministrative) {
        this.validationAdministrative = validationAdministrative;
    }
    
    /**
     *
     * @param etudiant
     * @param diplome
     * @param responsabiliteCivile
     * @param stage
     * @param entreprise
     */
    public DemandeConvention(Etudiant etudiant, Diplome diplome, ResponsabiliteCivile responsabiliteCivile, Stage stage, Entreprise entreprise) {
        this.etudiant = etudiant;
        this.diplome = diplome;
        this.responsabiliteCivile = responsabiliteCivile;
        this.stage = stage;
        this.entreprise = entreprise;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public Etudiant getEtudiant() {
        return etudiant;
    }

    /**
     *
     * @param etudiant
     */
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    /**
     *
     * @return
     */
    public Diplome getDiplome() {
        return diplome;
    }

    /**
     *
     * @param diplome
     */
    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    /**
     *
     * @return
     */
    public ResponsabiliteCivile getResponsabiliteCivile() {
        return responsabiliteCivile;
    }

    /**
     *
     * @param responsabiliteCivile
     */
    public void setResponsabiliteCivile(ResponsabiliteCivile responsabiliteCivile) {
        this.responsabiliteCivile = responsabiliteCivile;
    }

    /**
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

    /**
     *
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     *
     * @return
     */
    public Entreprise getEntreprise() {
        return entreprise;
    }

    /**
     *
     * @param entreprise
     */
    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }    
 
    /**
     *
     * @return
     */
    @Override
    public Long getKey() {
        return id;
    }

    /**
     *
     * @param key
     */
    @Override
    public void setKey(Long key) {
        this.id= key;
    }
    
        
    @Override
    public String toString() {
        return "DemandeConvention{" + "etudiant=" + etudiant + ", diplome=" + diplome + ", responsabiliteCivile=" + responsabiliteCivile + ", stage=" + stage + ", entreprise=" + entreprise + '}';
    }

    
}
