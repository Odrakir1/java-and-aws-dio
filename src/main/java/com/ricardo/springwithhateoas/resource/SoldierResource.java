package com.ricardo.springwithhateoas.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardo.springwithhateoas.controller.SoldierController;
import com.ricardo.springwithhateoas.controller.response.SoldierListResponse;
import com.ricardo.springwithhateoas.controller.response.SoldierResponse;
import com.ricardo.springwithhateoas.entity.SoldierEntity;





@Component
public class SoldierResource {

	private ObjectMapper objectMapper;
	
	public SoldierResource(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	public SoldierListResponse createLink(SoldierEntity soldierEntity) {
		SoldierListResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierListResponse.class);
		
		Link link = linkTo(methodOn(SoldierController.class).getSoldier(soldierEntity.getId())).withSelfRel();
		
		soldierListResponse.add(link);
		
		return soldierListResponse;
		
	}
	
	public SoldierResponse createLinkDetails(SoldierEntity soldierEntity) {
		SoldierResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierResponse.class);
		
		if(soldierEntity.getStatus().equals("dead")) {
			Link link = linkTo(methodOn(SoldierController.class).deleteSoldier(soldierEntity.getId()))
					.withRel("delete")
					.withTitle("Delete soldier")
					.withType("delete");
			
			soldierListResponse.add(link);
		}
		else {
			Link link = linkTo(methodOn(SoldierController.class).deleteSoldier(soldierEntity.getId()))
					.withRel("update")
					.withTitle("In guard")
					.withType("put");
			
			soldierListResponse.add(link);

		}
		
		
		return soldierListResponse;
		
	}
}
