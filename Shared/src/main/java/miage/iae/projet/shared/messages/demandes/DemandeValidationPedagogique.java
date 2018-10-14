/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages.demandes;

import miage.iae.projet.shared.messages.Diplome;
import miage.iae.projet.shared.messages.Entreprise;
import miage.iae.projet.shared.messages.Etudiant;
import miage.iae.projet.shared.messages.ResponsabiliteCivile;
import miage.iae.projet.shared.messages.Stage;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationPedagogique extends DemandeValidation {

    public Stage stage;
    public Entreprise entreprise;
    public Diplome diplome;

    public DemandeValidationPedagogique() {
        super();
        this.stage = new Stage();
        this.entreprise = new Entreprise();
        this.diplome = new Diplome();
    }

}
