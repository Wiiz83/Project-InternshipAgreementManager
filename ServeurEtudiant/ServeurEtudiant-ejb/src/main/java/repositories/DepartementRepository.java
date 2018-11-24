/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.ejb.Singleton;
import shared.donnees.Departement;
import shared.donnees.Diplome;

/**
 *
 * @author uzanl
 */
@Singleton
public class DepartementRepository implements DepartementRepositoryLocal {

    ArrayList<Departement> listeDepartements = new ArrayList<>();

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Departement get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<Departement> getAll() {
        return listeDepartements;
    }

    /**
     *
     * @param dp
     */
    @Override
    public void insert(Departement dp) {
        listeDepartements.add(dp);
    }

    /**
     *
     * @param id
     * @param dp
     */
    @Override
    public void update(Long id, Departement dp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param d
     * @return
     */
    @Override
    public Collection<Diplome> obtenirDiplomes(Departement d) {
        return d.getDiplomes();
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<Diplome> obtenirTousLesDiplomes() {
        return this.listeDepartements
                .stream()
                .flatMap(o -> o.getDiplomes().stream())
                .sorted(Comparator.comparing((diplome) -> diplome.getNiveau()))
                .collect(Collectors.toSet());
    }

}
