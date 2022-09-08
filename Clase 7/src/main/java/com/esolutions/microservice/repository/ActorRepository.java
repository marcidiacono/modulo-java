package com.esolutions.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esolutions.microservice.models.ActorEntity;

public interface ActorRepository extends JpaRepository<ActorEntity, Long>{

}
