/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import miage.iae.projet.shared.messages.DemandeConvention;
import miage.iae.projet.shared.messages.Diplome;
import miage.iae.projet.shared.messages.Entreprise;
import miage.iae.projet.shared.messages.Etudiant;
import miage.iae.projet.shared.messages.ResponsabiliteCivile;
import miage.iae.projet.shared.messages.Stage;

/**
 *
 * @author Mahdi
 */
@Singleton
@Startup
public class TestJMSContext {

    @Inject
    @JMSConnectionFactory("jms/Demande_conventionFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/Demande_convention")
    private Queue demande_convention;
    
    @PostConstruct
    public void init() {        
        JMSProducer mp =  context.createProducer();
        mp.send(demande_convention, DemandeConventionTest() );
    }

 private DemandeConvention DemandeConventionTest() {
        DemandeConvention c = new DemandeConvention(
                new Etudiant(),
                new Diplome(), new ResponsabiliteCivile(),
                new Stage(),
                new Entreprise()
        );

        c.etudiant.nom = "NomTest";
        c.etudiant.prenom = "prenomTest";
        c.etudiant.numero = new Long(123123);

        c.diplome.intitule = "MIAGE";
        c.diplome.niveau = "M2";

        c.responsabiliteCivile.compagnieAssurance = "CMP";
        c.responsabiliteCivile.nContrat = "C545X10";

        c.stage.debut = new Date();
        c.stage.fin = new Date();
        c.stage.gratification = 111.12;
        c.stage.sujet = "sujet stage ";
        
        c.entreprise.nom= "comp";
        c.entreprise.siret="0051q5sd";
        return c;
    }
}
