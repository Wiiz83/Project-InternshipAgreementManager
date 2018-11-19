/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import shared.donnees.HasKey;

/**
 *
 * @author Mahdi
 * @param <T>
 */
public class KVRepository<T extends HasKey> implements Repository<T> {

    protected Map<Long, T> kvstore = new HashMap<>();
    private Long id =new Long(0); 

    @Override
    public T get(Long id) {
        return this.kvstore.get(id);
    }

    @Override
    public Collection<T> getAll() {
        return this.kvstore.values();
    }

    @Override
    public void insert(T dp) {
        if (dp.getKey() == null) {
            this.kvstore.put(this.generateID(), dp);
            dp.setKey(id);
        } else {
            this.kvstore.put(dp.getKey(), dp);
        }
    }

    @Override
    public void update(Long id, T dp) {
        // ne fait rien en pratique car en mémoire, mais on la met au cas où on 
        // décide de persister
    }

    @Override
    public void delete(Long id) {
        this.kvstore.remove(id);
    }

    private Long generateID() {         
        Set<Long> ids = this.kvstore.keySet();
        if (ids.isEmpty()) {
            id++;
        } else {
            id= this.kvstore.keySet().stream().max(Comparator.naturalOrder()).get() + 1;
        }
        return id;
    }

}
