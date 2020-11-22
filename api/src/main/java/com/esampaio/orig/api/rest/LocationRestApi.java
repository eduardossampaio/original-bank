package com.esampaio.orig.api.rest;

import com.esampaio.orig.api.entities.Location;
import com.esampaio.orig.api.services.location.LocationService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class LocationRestApi {

    @Autowired
    LocationService locationService;

    @GetMapping("/location")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "lista de todas as localizações registradas"),
            @ApiResponse(code = 500, message = "Um erro desconhecido ocorreu"),
    })
    public List<Location> listLocations() {
        return locationService.listLocations();
    }

    @PostMapping("/location")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok se conseguiu criar a localidade com sucesso"),
            @ApiResponse(code = 500, message = "Um erro desconhecido ocorreu"),
    })
    public DefaultSuccessResponse createLocation(@RequestBody  LocationsRequestBody location) throws IllegalArgumentException{
        locationService.createLocation(location);
        return defaultSuccessResponse("Location Successful created");
    }

    @PutMapping("/location")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok se conseguiu atualizar a localidade com sucesso"),
            @ApiResponse(code = 500, message = "Um erro desconhecido ocorreu"),
    })
    public DefaultSuccessResponse updateLocation(@RequestBody LocationsRequestBody location){
        locationService.updateLocation(location);
        return defaultSuccessResponse("Location Successful updated");
    }

    @DeleteMapping("/location/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok se conseguiu criar a deletar com sucesso"),
            @ApiResponse(code = 500, message = "Um erro desconhecido ocorreu"),
    })
    public DefaultSuccessResponse deleteLocation(@PathVariable Integer id){
        locationService.deleteLocation(id);
        return defaultSuccessResponse("Location Successful deleted");
    }

    private DefaultSuccessResponse defaultSuccessResponse(String message){
        return new DefaultSuccessResponse(message);
    }


}
