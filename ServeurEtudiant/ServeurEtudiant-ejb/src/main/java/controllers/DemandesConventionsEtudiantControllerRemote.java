/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Collection;
import javax.ejb.Local;
import javax.ejb.Remote;
import shared.donnees.Departement;
import shared.donnees.Diplome;

/**
 *
 * @author Mahdi
 */
@Remote
public interface DemandesConventionsEtudiantControllerRemote {

    void ajouterDemande(shared.messages.demandes.DemandeConventionMessage demande);
    
      Collection<Departement> obtenirDepartements();
    
      Collection<Diplome> obtenirDiplomes(Departement d);
      
      Collection<Diplome> obtenirTousLesDiplomes();

}
