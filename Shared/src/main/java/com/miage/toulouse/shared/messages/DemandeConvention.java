/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.toulouse.shared.messages;

/**
 *
 * @author Mahdi
 */
public class DemandeConvention {
    public Etudiant etudiant;
    public Stage stage;
    public Entreprise entreprise ;
    
    public DemandeConvention() {
        this.etudiant = new Etudiant();
        this.stage = new Stage();
        this.entreprise = new Entreprise ();
    }
}
