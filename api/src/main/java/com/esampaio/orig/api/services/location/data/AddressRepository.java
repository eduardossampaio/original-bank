package com.esampaio.orig.api.services.location.data;

import com.esampaio.orig.api.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,String> {
}
