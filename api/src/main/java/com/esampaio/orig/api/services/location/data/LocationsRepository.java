package com.esampaio.orig.api.services.location.data;

import com.esampaio.orig.api.Customer;
import com.esampaio.orig.api.entities.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationsRepository  extends CrudRepository<Location,Integer> {

    Location getLocationById(Integer id);
}
