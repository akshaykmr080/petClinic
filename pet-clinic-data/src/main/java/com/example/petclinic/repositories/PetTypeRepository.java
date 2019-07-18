package com.example.petclinic.repositories;

import com.example.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by akshaykumar on 7/17/19.
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
