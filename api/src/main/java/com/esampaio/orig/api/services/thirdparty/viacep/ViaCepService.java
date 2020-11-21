package com.esampaio.orig.api.services.thirdparty.viacep;

import com.esampaio.orig.api.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    public String viaCepUrl = "";

    public ViaCepService(){
        //TODO passar via parametro
//        viaCepUrl = "viacep.com.br/ws/01001000/json/";
        viaCepUrl = "http://viacep.com.br/ws";
    }

    @Autowired
    RestTemplate restTemplate;

    public ViaCepResponse getInfoByCep(String cep){
        return (ViaCepResponse)  restTemplate.getForObject(requestUrl(cep), ViaCepResponse.class);
    }

    private String requestUrl(String cep){
        return viaCepUrl+"/"+cep+"/json";//TODO fazer via URI
    }
}
