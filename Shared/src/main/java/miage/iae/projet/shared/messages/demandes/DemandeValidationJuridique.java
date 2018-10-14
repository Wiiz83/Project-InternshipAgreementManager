/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages.demandes;

import miage.iae.projet.shared.messages.Entreprise;
import miage.iae.projet.shared.messages.Etudiant;
import miage.iae.projet.shared.messages.ResponsabiliteCivile;
import miage.iae.projet.shared.messages.Stage;

/**
 *
 * @author Mahdi
 */
public class DemandeValidationJuridique extends DemandeValidation {

    public ResponsabiliteCivile responsabiliteCivile;
    public Stage stage;
    public Entreprise entreprise;

    public DemandeValidationJuridique() {
        super();
        this.responsabiliteCivile = new ResponsabiliteCivile();
        this.stage = new Stage();
        this.entreprise = new Entreprise();
    }
}
