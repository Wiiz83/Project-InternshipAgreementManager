/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import miage.iae.projet.shared.messages.DemandeConvention;

/**
 *
 * @author Mahdi
 */
@MessageDriven(mappedName = "jms/Demande_convention", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class EtudiantMB implements MessageListener {

   
    
    public EtudiantMB() {
    }
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {  
            ObjectMessage om = (ObjectMessage) message;  
            try {  
                DemandeConvention demande = om.getBody(DemandeConvention.class);  
                System.out.println("Stages::Demande_convention :" + demande);  
            } catch (JMSException e) {  
            }  
        }  
    }

   
    
    
}
