package com.esampaio.orig.api.services.address;

import com.esampaio.orig.api.entities.Address;
import com.esampaio.orig.api.entities.Location;
import com.esampaio.orig.api.services.location.data.AddressRepository;
import com.esampaio.orig.api.services.thirdparty.viacep.ViaCepResponse;
import com.esampaio.orig.api.services.thirdparty.viacep.ViaCepService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest {

    @Mock
    ViaCepService viaCepService;

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AddressService addressService;



    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);

        ViaCepResponse response = new ViaCepResponse();
        response.setCep("12345-678");
        response.setLogradouro("Rua dos bobos");
        response.setComplemento("Numero 0");
        Mockito.when(viaCepService.getInfoByCep("12345-678")).thenReturn(response);
        Address address = new Address();
        address.setCep("12345-678");
        address.setLogradouro("Rua dos bobos");
        address.setComplemento("Numero 0");
        Mockito.when(addressRepository.save(address)).thenReturn(address);
    }

    @Test
    void getAddress() {
        Address address = addressService.getAddress("12345-678");
        assertNotNull(address);
    }

    @Test
    void getAndSave() {
        Address address = addressService.getAndSave("12345-678");
        assertNotNull(address);
    }
}