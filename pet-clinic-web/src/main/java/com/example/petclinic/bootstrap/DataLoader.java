package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.model.PetType;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by akshaykumar on 6/20/19.
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private PetTypeService petTypeService;

    public DataLoader(
                OwnerService ownerService,
                VetService vetService,
                PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... strings) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("dog");
        PetType savedCat = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Vidhatri");
        owner.setLastName("Akshay");
        owner.setAddress("195 S Sunnyvale Ave");
        owner.setCity("Boston");
        owner.setTelephone("12345678");

        Pet Vpet = new Pet();
        Vpet.setType(dog);
        Vpet.setOwner(owner);
        Vpet.setBirthDate(LocalDate.now());
        Vpet.setName("V Dog");

        owner.getPets().add(Vpet);
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Aakash");
        owner2.setLastName("Kumar");

        owner2.setAddress("195 S Sunnyvale Ave");
        owner2.setCity("Boston");
        owner2.setTelephone("12345678");

        Pet Apet = new Pet();
        Apet.setType(cat);
        Apet.setOwner(owner2);
        Apet.setName("Cat");
        Apet.setBirthDate(LocalDate.now());

        owner2.getPets().add(Apet);
        ownerService.save(owner2);

        Vet vet = new Vet();
        vet.setFirstName("Raju");
        vet.setLastName("Pandey fake");

        Vet vet2 = new Vet();
        vet2.setFirstName("Shreepathi");
        vet2.setLastName("doddappa");

        vetService.save(vet);
        vetService.save(vet2);

        System.out.println("Loaded Data");
    }
}
