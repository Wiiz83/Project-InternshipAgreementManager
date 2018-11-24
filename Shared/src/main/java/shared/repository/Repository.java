/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.repository;

import java.util.Collection;

/**
 *
 * @author Mahdi
 * @param <T>
 */
public interface Repository<T> {

    /**
     *
     * @param id
     * @return
     */
    public T get(Long id);

    /**
     *
     * @return
     */
    public Collection<T> getAll();

    /**
     *
     * @param dp
     */
    public void insert(T dp);
    
    // ne fait rien en pratique car en mémoire, mais on la met au cas où on 
    // décide de persister

    /**
     *
     * @param id
     * @param dp
     */
    public void update(Long id, T dp);

    /**
     *
     * @param id
     */
    public void delete(Long id);
    
    
}
