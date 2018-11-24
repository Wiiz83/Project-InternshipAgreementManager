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
import shared.messages.demandes.DemandeValidationPedagogique;

/**
 *
 * @author Mahdi
 */
@Stateless
@LocalBean
public class DemandeValidationPedagogiqueSender {

    @Inject
    @JMSConnectionFactory("jms/Demande_Validation_PedagogiqueFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/Demande_Validation_Pedagogique")
    private Queue queue;

    /**
     *
     * @param demande
     */
    public void demanderValidationPedagogique(DemandeValidationPedagogique demande) {
        JMSProducer mp = context.createProducer();
        mp.send(queue, demande);
    }
}
