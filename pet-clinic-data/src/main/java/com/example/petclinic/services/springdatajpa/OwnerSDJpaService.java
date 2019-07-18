package com.example.petclinic.services.springdatajpa;

import com.example.petclinic.model.Owner;
import com.example.petclinic.repositories.OwnerRepository;
import com.example.petclinic.repositories.PetRepository;
import com.example.petclinic.repositories.PetTypeRepository;
import com.example.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by akshaykumar on 7/17/19.
 */
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    OwnerSDJpaService(OwnerRepository ownerRepository,
                      PetRepository petRepository,
                      PetTypeRepository petTypeRepository) {

        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }
    @Override
    public Set<Owner> findAll() {
        HashSet<Owner> ownerSet = new HashSet<>();

        ownerRepository.findAll().forEach(owner -> ownerSet.add(owner));
        return ownerSet;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String LastName) {
        return ownerRepository.findByLastName(LastName);
    }
}
