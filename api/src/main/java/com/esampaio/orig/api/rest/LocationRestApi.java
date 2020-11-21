package com.esampaio.orig.api.rest;

import com.esampaio.orig.api.Customer;
import com.esampaio.orig.api.entities.Location;
import com.esampaio.orig.api.services.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController()
public class LocationRestApi {

    @Autowired
    LocationService locationService;

    @GetMapping("/listLocations")
    public List<Location> listLocations() {
        return locationService.listLocations();
    }

    @PostMapping("/createLocation")
    public void createLocation(@RequestBody  LocationsRequestBody location) throws IllegalArgumentException{
        locationService.createLocation(location);
    }

    @PutMapping("/updateLocation")
    public void updateLocation(@RequestBody LocationsRequestBody location){
        locationService.updateLocation(location);
    }

    @DeleteMapping("/deleteLocation")
    public void deleteLocation(@RequestBody LocationsRequestBody location){
        locationService.deleteLocation(location);
    }


}
