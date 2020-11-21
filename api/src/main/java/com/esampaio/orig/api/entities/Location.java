package com.esampaio.orig.api.entities;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String identifier;
    private String cep;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "cep" ,insertable = false, updatable = false, nullable = false)
//    @JoinColumn(name = "address_cep", referencedColumnName = "Address.cep" )
    @NotFound(action = NotFoundAction.IGNORE)
    private Address address;


    public Location(){
    }

    public Location(String identifier,String cep) {
        this.cep = cep;
        this.identifier = identifier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
