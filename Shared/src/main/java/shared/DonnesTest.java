/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.util.ArrayList;
import shared.donnees.Departement;
import shared.donnees.Diplome;
import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.ResponsabiliteCivile;
import shared.donnees.Stage;
import shared.messages.demandes.DemandeConventionMessage;

/**
 *
 * @author Mahdi
 */
public class DonnesTest {

    public ArrayList<Departement> listeDepartements = new ArrayList<>();
    public ArrayList<DemandeConventionMessage> demandes = new ArrayList<>();
    Diplome dip1 = new Diplome("Master 2", "Informatique");
    Diplome dip2 = new Diplome("L3", "MIAGE");
    Diplome dip3 = new Diplome("Master 2", "Stats");

    public DonnesTest() {

        Departement d0 = new Departement("Informatique");
        Departement d1 = new Departement("Études du monde anglophone");
        Departement d2 = new Departement("Mathématiques");
        Departement d3 = new Departement("Activités Physiques");
        Departement d4 = new Departement("Langues et Civilisations");

        listeDepartements.add(d0);
        listeDepartements.add(d1);
        listeDepartements.add(d2);
        listeDepartements.add(d3);
        listeDepartements.add(d4);

        dip1.setDepartement(d0);
        dip2.setDepartement(d0);
        dip3.setDepartement(d2);
        demandes.add(dc0());
        demandes.add(dc1());
        demandes.add(dc2());
    }

    private DemandeConventionMessage dc1() {
        Stage s = new Stage("11-12-2020", "11-12-2020", new Double(400), "Stage JEE!");
        Entreprise e = new Entreprise("48994888", "HighTech", "mail@HighTech.fr");
        Etudiant etudiant = new Etudiant("X5148", "Etudiant", "2", "etu@ups.com");
        ResponsabiliteCivile r = new ResponsabiliteCivile("AXA", "0545888F4");
        return new DemandeConventionMessage(
                etudiant,
                dip1,
                r,
                s,
                e
        );
    }

    private DemandeConventionMessage dc0() {
        Stage s = new Stage("11-12-2014", "11-12-2015", new Double(500), "Super stage!");
        Entreprise e = new Entreprise("49646464464", "Air France", "mail@af.fr");
        Etudiant etudiant = new Etudiant("0458GF", "LU", "ZAN", "mail@mail.com");
        ResponsabiliteCivile r = new ResponsabiliteCivile("MAF", "08478964TT88");
        return new DemandeConventionMessage(
                etudiant,
                dip2,
                r,
                s,
                e
        );
    }

    private DemandeConventionMessage dc2() {
        Stage s = new Stage("11-12-2014", "11-12-2015", new Double(800), "Stats!");
        Entreprise e = new Entreprise("Z894894", "StatR", "mail@statr.fr");
        Etudiant etudiant = new Etudiant("T65289", "Matheu", "Test", "etu25@stats.com");
        ResponsabiliteCivile r = new ResponsabiliteCivile("AXA", "078788F4");
        return new DemandeConventionMessage(
                etudiant,
                dip3,
                r,
                s,
                e
        );
    }

}
