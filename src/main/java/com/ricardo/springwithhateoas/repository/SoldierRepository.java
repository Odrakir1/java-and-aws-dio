package com.ricardo.springwithhateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.springwithhateoas.entity.SoldierEntity;

@Repository
public interface SoldierRepository extends JpaRepository<SoldierEntity, Long> {
}
