/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import donnees.DemandeJuridique;
import java.util.Collection;
import javax.ejb.Local;
import javax.ejb.Remote;
import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.ResponsabiliteCivile;
import shared.messages.demandes.DemandeValidationJuridique;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;

/**
 *
 * @author Mahdi
 */
@Remote
public interface DemandeJuridiqueControllerRemote {

    public Collection<DemandeJuridique> obtenirDemandes();

    public void ajouterDemande(DemandeJuridique demande);

    public void annulerDemande(NotificationAnnulationDemandeValidation n);

    public void refuserDemande(Long id, String motif);

    public void accepterDemande(Long id);

    public boolean verifierEntreprise(Entreprise e);

    public boolean verifierResponsabiliteCivile(Long id);
}
