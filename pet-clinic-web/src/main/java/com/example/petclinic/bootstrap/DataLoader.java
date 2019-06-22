package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by akshaykumar on 6/20/19.
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... strings) throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("Akshay");
        owner.setLastName("Shreekanth");

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Aakash");
        owner2.setLastName("Kumar");

        ownerService.save(owner2);

        Vet vet = new Vet();
        vet.setFirstName("Raju");
        vet.setLastName("Pandey");

        Vet vet2 = new Vet();
        vet2.setFirstName("Shreepathi");
        vet2.setLastName("doddappa");

        vetService.save(vet);
        vetService.save(vet2);

        System.out.println("Loaded Data");
    }
}
