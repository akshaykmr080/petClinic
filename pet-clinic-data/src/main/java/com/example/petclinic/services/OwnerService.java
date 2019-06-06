package com.example.petclinic.services;

import com.example.petclinic.model.Owner;

public interface OwnerService extends CRUDService<Owner, Long> {

    Owner findByLastName(String LastName);

}
