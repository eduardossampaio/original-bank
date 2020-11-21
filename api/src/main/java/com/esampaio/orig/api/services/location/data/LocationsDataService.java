package com.esampaio.orig.api.services.location.data;

import com.esampaio.orig.api.entities.Address;
import com.esampaio.orig.api.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LocationsDataService {
    @Autowired
    LocationsRepository locationsRepository;


    public List<Location> listAll() {
       return StreamSupport.stream(locationsRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }

    public Location getById(Integer id){
        return locationsRepository.findById(id).orElse(null);
    }

    public Location update(Location location){
        return locationsRepository.save(location);
    }

    public void saveNew(String identifier, String cep, Address address){
        Location location = new Location(identifier,cep);
        location.setAddress(address);

        locationsRepository.save(location);
    }

    public void delete(Integer id){
        locationsRepository.deleteById(id);
    }

}
