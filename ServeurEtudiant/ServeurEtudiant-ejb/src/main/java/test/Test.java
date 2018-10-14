/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

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
             sendJMSMessageToDemande_convention("!!!!");
         } catch (JMSException ex) {
             Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
     public Message createJMSMessageForjmsDemande_convention(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    public void sendJMSMessageToDemande_convention(Object messageData) throws JMSException {
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
    

}
