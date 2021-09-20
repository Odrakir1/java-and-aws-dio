package com.ricardo.springwithhateoas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardo.springwithhateoas.controller.request.SoldierEditRequest;
import com.ricardo.springwithhateoas.controller.response.SoldierListResponse;
import com.ricardo.springwithhateoas.controller.response.SoldierResponse;
import com.ricardo.springwithhateoas.dto.Soldier;
import com.ricardo.springwithhateoas.entity.SoldierEntity;
import com.ricardo.springwithhateoas.repository.SoldierRepository;
import com.ricardo.springwithhateoas.resource.SoldierResource;

@Service
public class SoldierService {

	private SoldierRepository soldierRepository;
	private ObjectMapper objectMapper;
	private SoldierResource soldierResource;
	
	
	public SoldierService(SoldierRepository soldierRepository, ObjectMapper objectMapper, SoldierResource soldierResource) {
		super();
		this.soldierRepository = soldierRepository;
		this.objectMapper = objectMapper;
		this.soldierResource = soldierResource;
	}


	public SoldierResponse getSoldier(Long id) {
		SoldierEntity soldier = soldierRepository.findById(id).orElseThrow(() -> new RuntimeException());
		SoldierResponse soldierResponse = soldierResource.createLinkDetails(soldier);
		return soldierResponse;
	}

	public void addSoldier(Soldier soldier) {
		SoldierEntity soldierEntity = objectMapper.convertValue(soldier, SoldierEntity.class);
		soldierRepository.save(soldierEntity);
	}

	public void updateSoldier(Long id, SoldierEditRequest soldierEditRequest) {
		SoldierEntity soldierEntity = objectMapper.convertValue(soldierEditRequest, SoldierEntity.class);
		soldierEntity.setId(id);
		soldierRepository.save(soldierEntity);
	}

	public void deleteSoldier(Long id) {
		SoldierEntity soldier = soldierRepository.findById(id).orElseThrow(() -> new RuntimeException());
		soldierRepository.delete(soldier);
	}

	public  CollectionModel<SoldierListResponse> getSoldiers() {
		
		List<SoldierEntity> all = soldierRepository.findAll();
		List<SoldierListResponse> soldierStream = all.stream().map(it -> soldierResource.createLink(it))
				.collect(Collectors.toList());
		
		CollectionModel<SoldierListResponse> model = CollectionModel.of(soldierStream);
		
		return model;
	}
}