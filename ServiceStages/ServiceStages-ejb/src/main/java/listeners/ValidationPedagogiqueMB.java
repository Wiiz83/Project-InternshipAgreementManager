/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import controllers.DemandesConventionsControllerRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import shared.messages.validations.ValidationJuridique;
import shared.messages.validations.ValidationPedagogique;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Validation_Pedagogique", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ValidationPedagogiqueMB implements MessageListener {
        @EJB
    DemandesConventionsControllerRemote ctrl;

    /**
     *
     */
    public ValidationPedagogiqueMB() {
    }
    
    /**
     *
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage om = (ObjectMessage) message;
            try {
                ValidationPedagogique demande = om.getBody(ValidationPedagogique.class);
                System.out.println("Stages::ValidationPedagogique :" + demande);
                ctrl.validationPedagogique(demande);
            } catch (JMSException ex) {
                Logger.getLogger(DemandeConventionStageMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
