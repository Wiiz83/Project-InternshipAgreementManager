/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senders;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import shared.messages.validations.ValidationAdministrative;

/**
 *
 * @author Mahdi
 */
@Stateless
@LocalBean
public class ValidationAdministrativeSender {

    @Inject
    @JMSConnectionFactory("jms/Validation_AdministrativeFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/Validation_Administrative")
    private Queue queue;

    /**
     *
     * @param validation
     */
    public void envoyerValidationAdministrative(ValidationAdministrative validation) {
        JMSProducer mp = context.createProducer();
        mp.send(queue, validation);
    }
}
