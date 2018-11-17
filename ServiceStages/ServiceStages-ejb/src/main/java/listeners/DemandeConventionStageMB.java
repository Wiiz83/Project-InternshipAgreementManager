/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import donnees.DemandeConvention;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import senders.ValidationAdministrativeSender;
import senders.ValidationPedagogiqueSender;
import shared.messages.demandes.DemandeValidationAdministrative;
import shared.messages.demandes.DemandeValidationPedagogique;

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
    
        @EJB
    ValidationPedagogiqueSender validationPedagogiqueSender;

    public DemandeConventionStageMB() {
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage om = (ObjectMessage) message;
            try {
                shared.messages.demandes.DemandeConventionMessage demande = om.getBody(shared.messages.demandes.DemandeConventionMessage.class);
                System.out.println("Stages::Demande_convention :" + demande);
                DemandeValidationAdministrative dva = new DemandeValidationAdministrative(new Long(54), demande.getEtudiant(), demande.getDiplome());
                validationAdministrativeSender.demanderValidationAdministrative(dva);    
                
                DemandeValidationPedagogique dvop = new DemandeValidationPedagogique(demande.getStage(),demande.getEntreprise(),demande.getDiplome(), new Long(42),demande.getEtudiant());
                validationPedagogiqueSender.demanderValidationPedagogique(dvop);
                
            } catch (JMSException ex) {
                Logger.getLogger(DemandeConventionStageMB.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
