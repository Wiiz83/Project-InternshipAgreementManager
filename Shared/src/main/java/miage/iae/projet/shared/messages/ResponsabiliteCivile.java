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
public class ResponsabiliteCivile  implements Serializable{

    public String compagnieAssurance ;
    public String nContrat;

    public ResponsabiliteCivile(String compagnieAssurance, String nContrat) {
        this.compagnieAssurance = compagnieAssurance;
        this.nContrat = nContrat;
    }

    public ResponsabiliteCivile() {
    }
    
    
    
    @Override
    public String toString() {
        return "ResponsabiliteCivile{" + "compagnieAssurance=" + compagnieAssurance + ", nContrat=" + nContrat + '}';
    }
}
