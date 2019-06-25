package com.example.petclinic.services.map;

import com.example.petclinic.model.PetType;
import com.example.petclinic.services.PetTypeService;

import java.util.Set;

/**
 * Created by akshaykumar on 6/24/19.
 */
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}