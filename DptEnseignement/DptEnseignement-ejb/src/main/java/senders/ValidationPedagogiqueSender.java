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
import miage.iae.projet.shared.messages.validations.ValidationPedagogique;

/**
 *
 * @author Mahdi
 */
@Stateless
@LocalBean
public class ValidationPedagogiqueSender {

    @Inject
    @JMSConnectionFactory("jms/Validation_PedagogiqueFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/Validation_Pedagogique")
    private Queue queue;

    public void envoyerValidationPedagogique(ValidationPedagogique validation) {
        JMSProducer mp = context.createProducer();
        mp.send(queue, validation);
    }
}
