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
import shared.messages.demandes.DemandeValidationAdministrative;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Demande_Validation_Administrative", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class DemandesValidationListener implements MessageListener {

    @EJB
    DemandesAdministrativesControllerRemote ctrl;

    /**
     *
     */
    public DemandesValidationListener() {
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
                DemandeValidationAdministrative demande = om.getBody(DemandeValidationAdministrative.class);
                System.out.println("Scolarite::Demande_Validation_Administrative :" + demande);
                ctrl.ajouterDemande(demande);
            } catch (JMSException ex) {
                Logger.getLogger(DemandesValidationListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
