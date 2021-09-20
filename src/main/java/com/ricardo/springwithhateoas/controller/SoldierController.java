package com.ricardo.springwithhateoas.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardo.springwithhateoas.controller.request.SoldierEditRequest;
import com.ricardo.springwithhateoas.controller.response.SoldierListResponse;
import com.ricardo.springwithhateoas.controller.response.SoldierResponse;
import com.ricardo.springwithhateoas.dto.Soldier;
import com.ricardo.springwithhateoas.service.SoldierService;

@RestController
@RequestMapping("/v1/soldier")
public class SoldierController {

	private SoldierService soldierService;
	private ObjectMapper objectMapper;

	public SoldierController(SoldierService soldierService, ObjectMapper objectMapper) {
		this.soldierService = soldierService;
		this.objectMapper = objectMapper;
	}

	@GetMapping("/{id}")
	public ResponseEntity<SoldierResponse> getSoldier(@PathVariable() Long id) {
		SoldierResponse soldierResponse = soldierService.getSoldier(id);
		return ResponseEntity.status(HttpStatus.OK).body(soldierResponse);
	}

	@PostMapping
	public ResponseEntity addSoldier(@RequestBody Soldier soldier) {
		soldierService.addSoldier(soldier);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity updateSoldier(@PathVariable() Long id, @RequestBody SoldierEditRequest soldierEditRequest) {
		soldierService.updateSoldier(id, soldierEditRequest);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteSoldier(@PathVariable Long id) {
		soldierService.deleteSoldier(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<CollectionModel<SoldierListResponse>> getSoldiers() {
		CollectionModel<SoldierListResponse> soldiers = soldierService.getSoldiers();
		return ResponseEntity.status(HttpStatus.OK).body(soldiers);
	}
	
	@PutMapping("/realocate/{id}")
	public ResponseEntity realocate(@PathVariable Long id) {
		//some logic
		return ResponseEntity.ok().build();
	}
}
