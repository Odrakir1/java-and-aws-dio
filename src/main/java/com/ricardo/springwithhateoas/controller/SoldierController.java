package com.ricardo.springwithhateoas.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import com.ricardo.springwithhateoas.dto.Soldier;

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
    public ResponseEntity<SoldierResponse> buscarSoldier(@PathVariable() Long id) {
        SoldierResponse soldierResponse = soldierService.buscarSoldier(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldierResponse);
    }

    @PostMapping
    public ResponseEntity criarSoldier(@RequestBody Soldier soldier) {
        soldierService.criarSoldier(soldier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity editarSoldier(@PathVariable() Long id,
                                        @RequestBody SoldierEditRequest soldierEditRequest) {
        soldierService.alterarSoldier(id, soldierEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSoldier(@PathVariable Long id) {
        soldierService.deletarSoldier(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<SoldierResponse>> buscarSoldiers() {
        List<SoldierResponse> soldiers = soldierService.buscarSoldiers().stream()
                .map(it -> objectMapper.convertValue(it, SoldierResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(soldiers);
    }
}



