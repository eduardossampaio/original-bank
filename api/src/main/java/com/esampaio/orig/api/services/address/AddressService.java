package com.esampaio.orig.api.services.address;

import com.esampaio.orig.api.entities.Address;
import com.esampaio.orig.api.services.location.data.AddressRepository;
import com.esampaio.orig.api.services.thirdparty.viacep.ViaCepResponse;
import com.esampaio.orig.api.services.thirdparty.viacep.ViaCepService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    ViaCepService viaCepService;

    @Autowired
    AddressRepository addressRepository;

    public Address getAddress(String cep){
        Address address = new Address();
        ViaCepResponse cepInfo = viaCepService.getInfoByCep(cep);
        BeanUtils.copyProperties(cepInfo,address);
        return address;
    }

    public Address getAndSave(String cep){
        Address address = getAddress(cep);
        address = addressRepository.save(address);
        return address;
    }
}
