/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.shared.messages;

import java.io.Serializable;

/**
 *
 * @author Mahdi
 */
public class Diplome implements Serializable {

    public String niveau;
    public String intitule;
    
    public Diplome() {
    }

    public Diplome(String niveau, String intitule) {
        this.niveau = niveau;
        this.intitule = intitule;
    }
    
    @Override
    public String toString() {
        return "Diplome{" + "niveau=" + niveau + ", intitule=" + intitule + '}';
    }
}
