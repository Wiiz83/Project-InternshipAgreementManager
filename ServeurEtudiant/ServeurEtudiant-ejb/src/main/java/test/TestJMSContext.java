/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
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
        JMSProducer mp = context.createProducer();
        mp.send(demande_convention,
                new DemandeConventionMessage(
                        new Etudiant("TEST", "TEST", "TEST"),
                        new Diplome("M", "MIAGE", new Departement("Info")), 
                        new ResponsabiliteCivile("qsd", "455"),
                        new Stage(new Date(), new Date(), 45.541, ""),
                        new Entreprise("qsdqsdf", "qsd")
                ));
    }
}
