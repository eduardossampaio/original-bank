package com.esampaio.orig.api.services.location;

import com.esampaio.orig.api.entities.Address;
import com.esampaio.orig.api.entities.Location;
import com.esampaio.orig.api.rest.LocationsRequestBody;
import com.esampaio.orig.api.services.address.AddressService;
import com.esampaio.orig.api.services.location.data.LocationsDataService;
import com.esampaio.orig.api.services.thirdparty.viacep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class LocationService {


    @Autowired
    AddressService addressService;

    @Autowired LocationsDataService locationsDataService;

    @Autowired
    ViaCepService viaCepService;

    public List<Location> listLocations() {
        return locationsDataService.listAll();
    }



    public void createLocation(@RequestBody LocationsRequestBody request){
        Address address = addressService.getAndSave(request.getCep());
        locationsDataService.saveNew(request.getIdentifier(),request.getCep(),address);
    }


    public void updateLocation(@RequestBody LocationsRequestBody request){
        Location locationEntity = locationsDataService.getById(request.getId());

        if(request.getIdentifier() != null) {
            locationEntity.setIdentifier(request.getIdentifier());
        }

        if(request.getCep() != null && ! request.getCep().equals(locationEntity.getCep())) {
            Address address = addressService.getAndSave(request.getCep());
            locationEntity.setAddress(address);
        }
        locationsDataService.update(locationEntity);

    }

    public void deleteLocation(@RequestBody LocationsRequestBody location){
       locationsDataService.delete(location.getId());
    }
}
