package com.ricardo.intermediate.service;

import org.springframework.stereotype.Service;

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
	
//	public Soldier createSoldier(Soldier soldier) {
//		
//	}
	
}
