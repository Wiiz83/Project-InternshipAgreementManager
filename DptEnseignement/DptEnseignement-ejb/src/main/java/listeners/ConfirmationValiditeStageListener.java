/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import controllers.PreconventionControllerRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import shared.messages.notifications.ConfirmationValiditeStage;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Confirmation_Validite_Stage", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ConfirmationValiditeStageListener implements MessageListener {

    @EJB
    PreconventionControllerRemote pc;

    public ConfirmationValiditeStageListener() {
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage om = (ObjectMessage) message;
            try {
                ConfirmationValiditeStage notif = om.getBody(ConfirmationValiditeStage.class);
                System.out.println("DptEnseignement::ConfirmationValiditeStage :" + notif);
                pc.confirmerValidationFinale(notif);
            } catch (JMSException ex) {
                Logger.getLogger(DemandeValidationPedagogiqueListener.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
