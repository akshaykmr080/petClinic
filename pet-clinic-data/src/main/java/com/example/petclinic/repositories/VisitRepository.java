package com.example.petclinic.repositories;

import com.example.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by akshaykumar on 7/17/19.
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
