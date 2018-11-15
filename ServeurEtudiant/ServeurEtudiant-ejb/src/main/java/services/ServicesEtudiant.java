/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import miage.iae.projet.shared.donnees.DemandeConvention;

/**
 *
 * @author Mahdi
 */
@Stateless
@LocalBean
public class ServicesEtudiant {

    @Inject
    @JMSConnectionFactory("jms/Demande_conventionFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/Demande_convention")
    private Queue demande_convention_file;

    public void ajouterDemandeDeConvention(DemandeConvention demandeConvention) {
        JMSProducer mp = context.createProducer();
        mp.send(demande_convention_file, demandeConvention);
    }

}
