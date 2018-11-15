/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.notifications;

/**
 *
 * @author Mahdi
 */
public class NotificationAnnulationDemandeValidation extends Notification {
    String cause;

    public NotificationAnnulationDemandeValidation(String cause, int idDemandeConvention) {
        super(idDemandeConvention);
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "NotificationAnnulationDemandeValidation{" + "cause=" + cause + super.toString() + '}';
    }
    
}
