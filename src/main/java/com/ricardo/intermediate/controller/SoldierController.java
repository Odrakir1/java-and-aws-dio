package com.ricardo.intermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.intermediate.controller.request.SoldierEditRequest;
import com.ricardo.intermediate.dto.Soldier;
import com.ricardo.intermediate.service.SoldierService;

@RestController
@RequestMapping("/v1/soldier")
public class SoldierController {

	@Autowired
	SoldierService soldierService;

	@GetMapping("/{cpf}")
	public ResponseEntity<List<Soldier>> getSoldiers() {
		List<Soldier> soldiers = soldierService.getSoldiers();

		return ResponseEntity.ok().body(soldiers);
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<Soldier> getSoldier(@PathVariable String cpf) {
		Soldier soldier = soldierService.getSoldier(cpf);

		return ResponseEntity.ok(soldier);
	}

	@PostMapping
	public ResponseEntity postSoldier(@RequestBody Soldier soldier) {
		soldierService.createSoldier(soldier);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{cpf}")
	public ResponseEntity editSoldier(@PathVariable String cpf, @RequestBody SoldierEditRequest soldier) {
		soldierService.updateSoldier(cpf, soldier);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{cpf}")
	public ResponseEntity deleteSoldier(@PathVariable String cpf) {
		soldierService.deleteSoldier(cpf);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
