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
import javax.jms.Topic;
import shared.messages.demandes.DemandeValidationAdministrative;
import shared.messages.notifications.NotificationAnnulationDemandeValidation;

/**
 *
 * @author Mahdi
 */
@Stateless
@LocalBean
public class NotificationAnnulationDemandeSender {

    @Inject
    @JMSConnectionFactory("jms/Notification_Annulation_Demande_ValidationFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/Notification_Annulation_Demande_Validation")
    private Topic Notification_Annulation_Demande_ValidationTopic;

    public void notifierAnnulation(NotificationAnnulationDemandeValidation annulation) {
        JMSProducer mp = context.createProducer();
        mp.send(Notification_Annulation_Demande_ValidationTopic, annulation);
    }

}
