/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import miage.iae.projet.shared.messages.DemandeConvention;
import miage.iae.projet.shared.messages.demandes.DemandeValidationAdministrative;
import senders.ValidationAdministrativeSender;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Demande_convention", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class DemandeConventionStageMB implements MessageListener {

    @EJB
    ValidationAdministrativeSender validationAdministrativeSender;

    public DemandeConventionStageMB() {
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage om = (ObjectMessage) message;
            try {
                DemandeConvention demande = om.getBody(DemandeConvention.class);
                System.out.println("Stages::Demande_convention :" + demande);
                DemandeValidationAdministrative dva = new DemandeValidationAdministrative(new Long(555), demande.etudiant, demande.diplome);
                validationAdministrativeSender.demanderValidationAdministrative(dva);
            } catch (JMSException ex) {
                Logger.getLogger(DemandeConventionStageMB.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
