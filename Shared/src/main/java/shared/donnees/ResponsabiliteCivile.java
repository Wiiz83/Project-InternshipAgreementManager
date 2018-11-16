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
public class ResponsabiliteCivile  implements Serializable{

    private String compagnieAssurance ;
    private String nContrat;

    public ResponsabiliteCivile(String compagnieAssurance, String nContrat) {
        this.compagnieAssurance = compagnieAssurance;
        this.nContrat = nContrat;
    }

    public String getCompagnieAssurance() {
        return compagnieAssurance;
    }

    public String getnContrat() {
        return nContrat;
    }
    
    @Override
    public String toString() {
        return "ResponsabiliteCivile{" + "compagnieAssurance=" + compagnieAssurance + ", nContrat=" + nContrat + '}';
    }
}
