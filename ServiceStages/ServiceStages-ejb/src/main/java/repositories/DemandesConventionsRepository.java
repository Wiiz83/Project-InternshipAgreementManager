/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandeConvention;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import shared.repository.KVRepository;

/**
 *
 * @author Mahdi
 */
@Stateless
public class DemandesConventionsRepository extends KVRepository<DemandeConvention>
        implements DemandesConventionsRepositoryLocal {

    private final Collection<DemandeConvention> demandesArchivees = new HashSet<>();

    Predicate<DemandeConvention> estValide = d
            -> d.getValidationAdministrative() != null && d.getValidationAdministrative().isValide()
            && d.getValidationJuridique() != null && d.getValidationJuridique().isValide()
            && d.getValidationPedagogique() != null && d.getValidationPedagogique().isValide();

    @Override
    public Collection<DemandeConvention> obtenirDemandesEncours() {
        return this.kvstore.values().stream().filter(
                d -> d.getValidationAdministrative() == null
                || d.getValidationJuridique() == null
                || d.getValidationPedagogique() == null
        ).collect(Collectors.toSet());
    }

    @Override
    public Collection<DemandeConvention> obtenirDemandesValidees() {
        return this.kvstore
                .values()
                .stream()
                .filter(this.estValide
                ).collect(Collectors.toSet());
    }

    @Override
    public Collection<DemandeConvention> obtenirDemandesRefusees() {
        return this.kvstore
                .values()
                .stream()
                .filter(
                        d
                        -> d.getValidationAdministrative() != null && !d.getValidationAdministrative().isValide()
                        || d.getValidationJuridique() != null && !d.getValidationJuridique().isValide()
                        || d.getValidationPedagogique() != null && !d.getValidationPedagogique().isValide()
                ).collect(Collectors.toSet());
    }

    @Override
    public Collection<DemandeConvention> obtenirDemandesArchivees() {
        return this.demandesArchivees;
    }

    @Override
    public void archiver(Long key) {
        DemandeConvention d = this.kvstore.get(key);
        this.demandesArchivees.add(d);
        this.kvstore.remove(key);
    }

    @Override
    public boolean estValide(Long key) {
        return estValide.test(this.kvstore.get(key)) ;
    }

}
