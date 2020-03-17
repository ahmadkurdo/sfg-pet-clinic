package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    public Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save( T object){
        if (object != null){
            if (object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private long getNextId(){
        Long nextid = null;

        try {
            nextid = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e){
            nextid = 1L;
        }

        return nextid;


    }

}
