package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.*;
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
    private SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            SpecialityService specialityService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... strings) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("dog");
        PetType savedCat = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(Vpet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("sneezy kitty");
        visitService.save(catVisit);

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
        vet.getSpecialities().add(savedRadiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Shreepathi");
        vet2.setLastName("doddappa");
        vet2.getSpecialities().add(savedDentistry);
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet);
        vetService.save(vet2);

        System.out.println("Loaded Data");
    }
}
