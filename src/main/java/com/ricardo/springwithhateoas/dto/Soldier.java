package com.ricardo.springwithhateoas.dto;

public class Soldier {
    private Long id;
    private String cpf;
    private String name;
    private String race;
    private String weapon;
    private String status;

    public Long getId() {
        return id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
