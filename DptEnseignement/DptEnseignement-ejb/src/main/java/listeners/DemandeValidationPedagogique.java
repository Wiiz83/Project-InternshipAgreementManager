/*
 * To change this license header, choose License Headers in Project Properties.
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
@MessageDriven(mappedName = "jms/Demande_Validation_Pedagogique", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class DemandeValidationPedagogique implements MessageListener {
    
    public DemandeValidationPedagogique() {
    }
    
    @Override
    public void onMessage(Message message) {
    }
    
}
