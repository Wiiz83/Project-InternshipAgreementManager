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
public class Etudiant {

    public Long numero;
    public String nom;
    public String prenom;
    public ResponsabiliteCivile responsabiliteCivile;
    public Diplome diplome;

    public Etudiant() {
        this.diplome = new Diplome();
        this.responsabiliteCivile = new ResponsabiliteCivile();
    }
}
