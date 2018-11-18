/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senders;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import shared.messages.demandes.DemandeValidationAdministrative;

/**
 *
 * @author Mahdi
 */
public class ConfirmationValiditeStageSender {

    @Inject
    @JMSConnectionFactory("jms/Confirmation_Validite_StageFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/Confirmation_Validite_Stage")
    private Queue Confirmation_Validite_Stage;
    
       public void demanderConfirmerValiditeStage(shared.messages.notifications.ConfirmationValiditeStage c) {
        JMSProducer mp = context.createProducer();
        mp.send(Confirmation_Validite_Stage, c);
    }
       
}
