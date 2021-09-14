package com.ricardo.intermediate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.intermediate.dto.Soldier;
import com.ricardo.intermediate.service.SoldierService;

@RestController
@RequestMapping("/v1/soldier")
public class SoldierController {

	@Autowired
	SoldierService soldierService;

	@GetMapping("/{cpf}")
	public ResponseEntity<Soldier> getSoldier(@PathVariable String cpf) {
		Soldier soldier = soldierService.getSoldier(cpf);

		return ResponseEntity.ok().build();
	}

	@PostMapping
	public ResponseEntity postSoldier(@RequestBody Soldier soldier) {
		soldierService.createSoldier(soldier);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
//	@PutMapping
//	public ResponseEntity editUser(@RequestBody Soldier soldier) {
//		
//	}

}
