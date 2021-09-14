package com.ricardo.intermediate.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ricardo.intermediate.controller.request.SoldierEditRequest;
import com.ricardo.intermediate.dto.Soldier;

@Service
public class SoldierService {

	public Soldier getSoldier(String cpf){
		Soldier soldier = new Soldier();
		soldier.setCpf(cpf);
		soldier.setName("Legolas");
		soldier.setRace("Elf");
		soldier.setWeapon("Bow and arrow");
		
		return soldier;
	}

	public void createSoldier(Soldier soldier) {
		// TODO Auto-generated method stub
		
	}

	public void updateSoldier(String cpf, SoldierEditRequest soldier) {
		
		
	}

	public void deleteSoldier(String cpf) {
		// TODO Auto-generated method stub
		
	}

	public List<Soldier> getSoldiers() {
		Soldier soldier1 = new Soldier();
		soldier1.setCpf("123.123.456-12");
		soldier1.setName("Legolas");
		soldier1.setRace("Elf");
		soldier1.setWeapon("Bow and arrow");
		
		Soldier soldier2 = new Soldier();
		soldier2.setCpf("123.222.456-12");
		soldier2.setName("Oakenshield");
		soldier2.setRace("Dwarf");
		soldier2.setWeapon("Sword");
		
		return Arrays.asList(soldier1,soldier2);
		
	}
	
	
}
