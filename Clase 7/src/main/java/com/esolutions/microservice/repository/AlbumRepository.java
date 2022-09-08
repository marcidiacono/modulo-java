package com.esolutions.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esolutions.microservice.models.AlbumEntity;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long>{

}
