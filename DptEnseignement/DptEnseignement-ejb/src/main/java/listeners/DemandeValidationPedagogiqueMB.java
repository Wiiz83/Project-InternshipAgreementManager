/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Mahdi
 */
@JMSDestinationDefinition(name = "java:app/Demande_Validation_Pedagogique", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "Demande_Validation_Pedagogique")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/Demande_Validation_Pedagogique"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class DemandeValidationPedagogiqueMB implements MessageListener {
    
    public DemandeValidationPedagogiqueMB() {
    }
    
    @Override
    public void onMessage(Message message) {
    }
    
}
