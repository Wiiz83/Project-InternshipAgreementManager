/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.validations;

/**
 *
 * @author Mahdi
 */
public class ValidationPedagogique extends Validation {
    private final String nomTuteur;

    /**
     *
     * @param id
     * @param nomTuteur
     */
    public ValidationPedagogique(Long id, String nomTuteur) {
        super(id);
        this.nomTuteur = nomTuteur;
    }

    /**
     *
     * @param idDemandeValidation
     * @param valide
     * @param causeRefus
     */
    public ValidationPedagogique(Long idDemandeValidation, boolean valide, String causeRefus) {
        super(idDemandeValidation, valide, causeRefus);
        this.nomTuteur = null;
    }
    
    /**
     *
     * @return
     */
    public String getNomTuteur() {
        return nomTuteur;
    }
    
    @Override
    public String toString() {
        return "ValidationPedagogique{" + "nomTuteur=" + nomTuteur + super.toString() +'}';
    }

    /**
     *
     * @return
     */
    @Override
    public String getVolet() {
        return "Pédagogique";
    }
}
