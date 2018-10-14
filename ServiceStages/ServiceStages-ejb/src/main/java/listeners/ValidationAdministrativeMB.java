/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@MessageDriven(mappedName = "jms/Validation_Administrative", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ValidationAdministrativeMB implements MessageListener {
    
    public ValidationAdministrativeMB() {
    }
    
    @Override
    public void onMessage(Message message) {
    }
    
}
