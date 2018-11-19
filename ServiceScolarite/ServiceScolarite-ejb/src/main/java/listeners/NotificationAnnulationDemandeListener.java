/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import controllers.DemandesAdministrativesControllerRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Notification_Annulation_Demande_Validation", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/scolarite"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/Notification_Annulation_Demande_Validation"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class NotificationAnnulationDemandeListener implements MessageListener {

    @EJB
    DemandesAdministrativesControllerRemote ctrl;

    public NotificationAnnulationDemandeListener() {
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage om = (ObjectMessage) message;
            try {
                NotificationAnnulationDemandeValidation demande = om.getBody(NotificationAnnulationDemandeValidation.class);
                System.out.println("Scolarite::NotificationAnnulationDemandeValidation :" + demande);
                ctrl.annulerDemande(demande);
            } catch (JMSException ex) {
                Logger.getLogger(NotificationAnnulationDemandeListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
