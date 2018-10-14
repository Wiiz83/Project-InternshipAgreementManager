/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import miage.iae.projet.shared.messages.demandes.DemandeValidationAdministrative;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Demande_Validation_Administrative", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class DemandesValidationListener implements MessageListener {
    
    public DemandesValidationListener() {
    }
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {  
            ObjectMessage om = (ObjectMessage) message;  
            try {  
                DemandeValidationAdministrative  demande = om.getBody(DemandeValidationAdministrative.class);  
                System.out.println("Scolarite::Demande_Validation_Administrative :" + demande);  
            } catch (JMSException e) {  
            }  
        }  
    }
    
}