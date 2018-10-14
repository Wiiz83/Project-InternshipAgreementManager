/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Demande_convention", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class EtudiantMB implements MessageListener {

   
    
    public EtudiantMB() {
    }
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {  
            TextMessage tm = (TextMessage) message;  
            try {  
                String text = tm.getText();  
                System.out.println("Stages::Demande_convention :" + text);  
            } catch (JMSException e) {  
            }  
        }  
    }

   
    
    
}
