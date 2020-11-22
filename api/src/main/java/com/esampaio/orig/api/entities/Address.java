package com.esampaio.orig.api.entities;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {

    @Id()
    @Column(name = "id")
    private String cep;
    private Integer locationId;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

//    @OneToOne
//    @JoinColumn(name = "cep" ,insertable = false, updatable = false,nullable = true)
//    @NotFound(action = NotFoundAction.IGNORE)
//    private Location location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(cep, address.cep) && Objects.equals(locationId, address.locationId) && Objects.equals(logradouro, address.logradouro) && Objects.equals(complemento, address.complemento) && Objects.equals(bairro, address.bairro) && Objects.equals(localidade, address.localidade) && Objects.equals(uf, address.uf) && Objects.equals(ibge, address.ibge) && Objects.equals(gia, address.gia) && Objects.equals(ddd, address.ddd) && Objects.equals(siafi, address.siafi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, locationId, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi);
    }

    @Override
    public String toString() {
        return "ViaCepResponse{" + "cep='" + cep + '\'' + ", logradouro='" + logradouro + '\'' + ", complemento='" + complemento + '\'' + ", bairro='" + bairro + '\'' + ", localidade='" + localidade + '\'' + ", uf='" + uf + '\'' + ", ibge='" + ibge + '\'' + ", gia='" + gia + '\'' + ", ddd='" + ddd + '\'' + ", siafi='" + siafi + '\'' + '}';
    }

    public String getCep() {
        if(this.cep != null){
            return this.cep.replaceAll("-", "");
        }
        return null;
    }

    public void setCep(String cep) {
        if(cep!= null){
            this.cep = cep.replaceAll("-", "");
        }
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
}
