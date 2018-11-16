/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.notifications;

import java.io.Serializable;


/**
 *
 * @author Mahdi
 */
public abstract class Notification implements Serializable {
    private Long idDemandeConvention;

    public Notification(Long idDemandeConvention) {
        this.idDemandeConvention = idDemandeConvention;
    }

    public Long getIdDemandeConvention() {
        return idDemandeConvention;
    }

    @Override
    public String toString() {
        return "Notification{" + "idDemandeConvention=" + idDemandeConvention + '}';
    }
    
}
