package com.ricardo.springwithhateoas.controller.response;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SoldierResponse extends RepresentationModel {
    private Long id;
    private String cpf;
    private String name;
    private String race;
    private String weapon;

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String getRaca() {
        return race;
    }

    public void setRaca(String race) {
        this.race = race;
    }

    public String getArma() {
        return weapon;
    }

    public void setArma(String weapon) {
        this.weapon = weapon;
    }

}
