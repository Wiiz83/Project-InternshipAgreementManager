/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.toulouse.shared.messages.demandes;

import com.miage.toulouse.shared.messages.Diplome;
import com.miage.toulouse.shared.messages.Entreprise;
import com.miage.toulouse.shared.messages.Etudiant;
import com.miage.toulouse.shared.messages.ResponsabiliteCivile;
import com.miage.toulouse.shared.messages.Stage;

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
