/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Mahdi
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/DptEnseignement"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Notification_Annulation_Demande_Validation"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/Notification_Annulation_Demande_Validation"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class NotificationAnnulationDemande implements MessageListener {
    
    public NotificationAnnulationDemande() {
    }
    
    @Override
    public void onMessage(Message message) {
    }
    
}
