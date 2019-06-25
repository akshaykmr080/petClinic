package com.example.petclinic.services.map;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetService;
import com.example.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{

    private final PetTypeService petTypeService;

    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){

            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getType() != null){
                        if(pet.getType().getId() == null){
                            pet.setType(this.petTypeService.save(pet.getType()));
                        }
                    } else {
                        throw new RuntimeException("Pet type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String LastName) {
        return null;
    }
}
