package com.ricardo.springwithhateoas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardo.springwithhateoas.dto.Soldier;
import com.ricardo.springwithhateoas.entity.SoldierEntity;
import com.ricardo.springwithhateoas.repository.SoldierRepository;

@Service
public class SoldierService {

	private SoldierRepository soldierRepository;
	private ObjectMapper objectMapper;

	public SoldierService(SoldierRepository soldierRepository, ObjectMapper objectMapper) {
		this.soldierRepository = soldierRepository;
		this.objectMapper = objectMapper;
	}

	public SoldierResponse buscarSoldier(Long id) {
		SoldierEntity soldier = soldierRepository.findById(id).orElseThrow();
		SoldierResponse soldierResponse = objectMapper.convertValue(soldier, SoldierResponse.class);
		return soldierResponse;
	}

	public void criarSoldier(Soldier soldier) {
		SoldierEntity soldierEntity = objectMapper.convertValue(soldier, SoldierEntity.class);
		soldierRepository.save(soldierEntity);
	}

	public void alterarSoldier(Long id, SoldierEditRequest soldierEditRequest) {
		SoldierEntity soldierEntity = objectMapper.convertValue(soldierEditRequest, SoldierEntity.class);
		soldierEntity.setId(id);
		soldierRepository.save(soldierEntity);
	}

	public void deletarSoldier(Long id) {
		SoldierEntity soldier = soldierRepository.findById(id).orElseThrow();
		soldierRepository.delete(soldier);
	}

	public List<Soldier> buscarSoldiers() {
		List<SoldierEntity> all = soldierRepository.findAll();
		List<Soldier> soldierStream = all.stream().map(it -> objectMapper.convertValue(it, Soldier.class))
				.collect(Collectors.toList());
		return soldierStream;
	}
}