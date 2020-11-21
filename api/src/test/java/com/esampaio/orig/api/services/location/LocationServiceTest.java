package com.esampaio.orig.api.services.location;

import com.esampaio.orig.api.entities.Location;
import com.esampaio.orig.api.rest.LocationsRequestBody;
import com.esampaio.orig.api.services.address.AddressService;
import com.esampaio.orig.api.services.location.data.LocationsDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationServiceTest {
    @Mock
    AddressService addressService;

    @Mock
    LocationsDataService locationsDataService;

    @InjectMocks
    LocationService locationService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(locationsDataService.getById(1)).thenReturn(new Location("casa", "12345-678"));
    }

    @Test
    void listLocations() {
        List<Location> locations = locationService.listLocations();
        assertNotNull(locations);
    }

    @Test
    void createLocation() {

        LocationsRequestBody request = new LocationsRequestBody();
        request.setIdentifier("casa");
        request.setCep("12345-678");

        locationService.createLocation(request);
    }


    @Test
    void createLocationInvalidParams() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LocationsRequestBody request = new LocationsRequestBody();
            locationService.createLocation(request);
        });

    }

    @Test
    void updateLocation() {
        LocationsRequestBody request = new LocationsRequestBody();
        request.setIdentifier("casa");
        request.setCep("12345-678");
        request.setId(1);

        locationService.updateLocation(request);
    }
    @Test
    void updateLocationInvalidParams() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LocationsRequestBody request = new LocationsRequestBody();
            locationService.updateLocation(request);
        });

    }
    @Test
    void deleteLocation() {
        LocationsRequestBody request = new LocationsRequestBody();
        request.setIdentifier("casa");
        request.setCep("12345-678");
        request.setId(1);

        locationService.deleteLocation(request);
    }
}