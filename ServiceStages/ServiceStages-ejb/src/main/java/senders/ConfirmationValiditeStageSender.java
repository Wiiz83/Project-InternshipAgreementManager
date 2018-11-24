/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senders;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

/**
 *
 * @author Mahdi
 */
@Stateless
@LocalBean
public class ConfirmationValiditeStageSender {

    @Inject
    @JMSConnectionFactory("jms/Confirmation_Validite_StageFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/Confirmation_Validite_Stage")
    private Queue Confirmation_Validite_Stage;

    /**
     *
     * @param c
     */
    public void demanderConfirmerValiditeStage(shared.messages.notifications.ConfirmationValiditeStage c) {
        JMSProducer mp = context.createProducer();
        mp.send(Confirmation_Validite_Stage, c);
    }

}
