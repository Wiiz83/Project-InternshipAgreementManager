/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandeConvention;
import java.util.function.Predicate;

/**
 *
 * @author Mahdi
 */
public  class Predicats {
  
    /**
     *
     */
    public static Predicate<DemandeConvention> estValidee = d
            -> d.getValidationAdministrative() != null && d.getValidationAdministrative().isValide()
            && d.getValidationJuridique() != null && d.getValidationJuridique().isValide()
            && d.getValidationPedagogique() != null && d.getValidationPedagogique().isValide();
    
    /**
     *
     */
    public static Predicate<DemandeConvention> estRefusee = d
                        -> d.getValidationAdministrative() != null && !d.getValidationAdministrative().isValide()
                        || d.getValidationJuridique() != null && !d.getValidationJuridique().isValide()
                        || d.getValidationPedagogique() != null && !d.getValidationPedagogique().isValide();
                

}
