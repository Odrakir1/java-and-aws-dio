package com.ricardo.springwithhateoas.controller.request;

public class SoldierEditRequest {
	 private String cpf;
	    private String name;
	    private String race;
	    private String arma;
	    private String status;

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
	        return arma;
	    }

	    public void setArma(String arma) {
	        this.arma = arma;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}
