package com.esampaio.orig.api.rest;

public class LocationsRequestBody {

    private Integer id;
    private String identifier;
    private String cep;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep.replaceAll("-", "");
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
