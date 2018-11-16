/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.util.Collection;

/**
 *
 * @author Mahdi
 * @param <T>
 */
public interface Repository<T> {

    public T get(Long id);

    public Collection<T> getAll();

    public void insert(T dp);
    
    // ne fait rien en pratique car en mémoire, mais on la met au cas où on 
    // décide de persister
    public void update(Long id, T dp);

    public void delete(Long id);
}
