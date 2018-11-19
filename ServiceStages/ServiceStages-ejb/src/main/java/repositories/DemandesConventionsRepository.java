/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import donnees.DemandeConvention;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import javax.ejb.Singleton;
import shared.repository.KVRepository;

/**
 *
 * @author Mahdi
 */
@Singleton
public class DemandesConventionsRepository extends KVRepository<DemandeConvention>
        implements DemandesConventionsRepositoryLocal {

    private final Collection<DemandeConvention> demandesArchivees = new HashSet<>();

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
                .filter(Predicats.estValidee
                ).collect(Collectors.toSet());
    }

    @Override
    public Collection<DemandeConvention> obtenirDemandesRefusees() {
        return this.kvstore
                .values()
                .stream()
                .filter(Predicats.estRefusee
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

}
