/*
 * To change this license header, choose License Headers in Project Properties.
 * and open the template in the editor.
 */
package listeners;

import controllers.PreconventionController;
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
import shared.messages.demandes.DemandeValidationAdministrative;
import shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Demande_Validation_Pedagogique", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class DemandeValidationPedagogiqueListener implements MessageListener {

    @EJB
    PreconventionControllerRemote pc;

    /**
     *
     */
    public DemandeValidationPedagogiqueListener() {
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
                shared.messages.demandes.DemandeValidationPedagogique demande = om.getBody(DemandeValidationPedagogique.class);
                System.out.println("DptEnseignement::DemandeValidationPedagogique :" + demande);
                pc.ajouterDemande(demande);
            } catch (JMSException ex) {
                Logger.getLogger(DemandeValidationPedagogiqueListener.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
