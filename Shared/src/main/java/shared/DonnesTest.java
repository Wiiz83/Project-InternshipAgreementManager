/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.util.ArrayList;
import java.util.Date;
import shared.donnees.Departement;
import shared.donnees.Diplome;
import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.ResponsabiliteCivile;
import shared.donnees.Stage;

/**
 *
 * @author Mahdi
 */
public class DonnesTest {

    public Long id = new Long(564);
    public Stage s = new Stage(new Date(2018, 10, 10), new Date(2018, 12, 15), new Double(500), "Super stage!");
    public Entreprise e = new Entreprise("49646464464", "Air France");
    public Diplome d = new Diplome("Master 2", "Informatique", new Departement(""));
    public Etudiant etudiant = new Etudiant("TEST", "TEST", "TEST");
    public ResponsabiliteCivile r = new ResponsabiliteCivile("ResponsabiliteCivile_1","ResponsabiliteCivile_2");
    public ArrayList<Departement> listeDepartements = new ArrayList<>();

    public DonnesTest() {

        Departement d = new Departement("Informatique");
        Departement d1 = new Departement("Études du monde anglophone");
        Departement d2 = new Departement("Mathématiques");
        Departement d3 = new Departement("Activités Physiques");
        Departement d4 = new Departement("Langues et Civilisations");
        listeDepartements.add(d);
        listeDepartements.add(d1);
        listeDepartements.add(d2);
        listeDepartements.add(d3);
        listeDepartements.add(d4);

    }

}
