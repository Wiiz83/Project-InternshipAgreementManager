/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;


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
public class Test {

    @Resource(mappedName = "jms/Demande_convention")
    private Queue demande_convention;

    @Resource(mappedName = "jms/Demande_conventionFactory")
    private ConnectionFactory demande_conventionFactory;

    public Test() {
    }

    @PostConstruct
    public void init() {
        try {
            sendJMSMessageToDemande_convention(DemandeConventionTest());
        } catch (JMSException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Message createJMSMessageForjmsDemande_convention(Session session, Serializable messageData) throws JMSException {
        // TODO create and populate message to send
        ObjectMessage tm = session.createObjectMessage();
        tm.setObject(messageData);
        return tm;
    }

    public void sendJMSMessageToDemande_convention(Serializable messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = demande_conventionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(demande_convention);
            messageProducer.send(createJMSMessageForjmsDemande_convention(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
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

        return c;
    }

}
