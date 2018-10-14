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
import miage.iae.projet.shared.messages.demandes.DemandeValidationAdministrative;

/**
 *
 * @author Mahdi
 */
@Stateless
@LocalBean
public class ValidationAdministrativeSender {

    @Inject
    @JMSConnectionFactory("jms/Demande_Validation_AdministrativeFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/Demande_Validation_Administrative")
    private Queue demande_Validation_AdministrativeQueue;

    public void demanderValidationAdministrative(DemandeValidationAdministrative demande) {
        JMSProducer mp = context.createProducer();
        mp.send(demande_Validation_AdministrativeQueue, demande);
    }
}
