package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.VetService;
import com.example.petclinic.services.map.OwnerMapService;
import com.example.petclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by akshaykumar on 6/20/19.
 */

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;

    public DataLoader() {
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
    }

    @Override
    public void run(String... strings) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Akshay");
        owner.setLastName("Shreekanth");

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Aakash");
        owner2.setLastName("Kumar");

        ownerService.save(owner);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Raju");
        vet.setLastName("Pandey");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Shreepathi");
        vet2.setLastName("doddappa");

        vetService.save(vet);
        vetService.save(vet2);

        System.out.println("Loaded Data");
    }
}
