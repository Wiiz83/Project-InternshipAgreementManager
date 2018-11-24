/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import controllers.DemandeJuridiqueControllerRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import shared.messages.demandes.DemandeValidationJuridique;
import shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Demande_Validation_Juridique", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class DemandeValidationJuridiqueMB implements MessageListener {

    @EJB
    DemandeJuridiqueControllerRemote pc;

    /**
     *
     */
    public DemandeValidationJuridiqueMB() {
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
                shared.messages.demandes.DemandeValidationJuridique demande = om.getBody(DemandeValidationJuridique.class);
                System.out.println("Juridique::DemandeValidationJuridique :" + demande);
                pc.ajouterDemande(demande);
            } catch (JMSException ex) {
                Logger.getLogger(DemandeValidationJuridiqueMB.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
