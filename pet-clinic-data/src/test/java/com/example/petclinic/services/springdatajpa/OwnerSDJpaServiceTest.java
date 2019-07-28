package com.example.petclinic.services.springdatajpa;

import com.example.petclinic.model.Owner;
import com.example.petclinic.repositories.OwnerRepository;
import com.example.petclinic.repositories.PetRepository;
import com.example.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner dummyOwner;

    @BeforeEach
    void setUp() {
        dummyOwner = Owner.builder().id(1L).build();
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<Owner>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> ownersFromDB = ownerSDJpaService.findAll();

        assertNotNull(ownersFromDB);
        assertEquals(2, ownersFromDB.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(dummyOwner));
        Owner owner = ownerSDJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(dummyOwner);

        Owner savedOwner = ownerSDJpaService.save(dummyOwner);

        assertNotNull(savedOwner);
        assertEquals(dummyOwner.getId(), savedOwner.getId());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(dummyOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {

        ownerSDJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(any());
    }

    @Test
    void findByLastName() {

        String lastName = "Shreekanth";
        Owner owner = Owner.builder().id(1L).lastName(lastName).build();

        when(ownerRepository.findByLastName(anyString())).thenReturn(owner);
        Owner ownerFromDB = ownerSDJpaService.findByLastName(lastName);

        assertNotNull(ownerFromDB);
        assertEquals(lastName, ownerFromDB.getLastName());

        verify(ownerRepository, times(1)).findByLastName(any());
    }
}