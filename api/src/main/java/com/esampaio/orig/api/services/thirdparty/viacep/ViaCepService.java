package com.esampaio.orig.api.services.thirdparty.viacep;

import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import java.net.URISyntaxException;


@Service
public class ViaCepService {
    @Value( "${thirdparty.viacep.url}" )
    public String viaCepUrl = "";

    private static final String resultFormat = "json";


    @Autowired
    RestTemplate restTemplate;

    public ViaCepResponse getInfoByCep(String cep) {
        try {
            return (ViaCepResponse)  restTemplate.getForObject(requestUrl(cep), ViaCepResponse.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar informações de endereço");
        }
    }

    private String requestUrl(String cep) throws URISyntaxException {
      return new URIBuilder(viaCepUrl).setPathSegments("ws",cep, resultFormat).build().toString();
    }
}
