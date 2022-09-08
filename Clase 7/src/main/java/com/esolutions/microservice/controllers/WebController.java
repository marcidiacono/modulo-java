package com.esolutions.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.esolutions.microservice.assembler.ActorModelAssembler;
import com.esolutions.microservice.assembler.AlbumModelAssembler;
import com.esolutions.microservice.models.ActorEntity;
import com.esolutions.microservice.models.ActorModel;
import com.esolutions.microservice.models.AlbumEntity;
import com.esolutions.microservice.models.AlbumModel;
import com.esolutions.microservice.repository.ActorRepository;
import com.esolutions.microservice.repository.AlbumRepository;

@RestController
public class WebController {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private AlbumModelAssembler albumModelAssembler;
	
	@Autowired
	private ActorModelAssembler actorModelAssembler;
	
	@GetMapping("/api/actors")
	public ResponseEntity<CollectionModel<ActorModel>> getAllActors() {
		List<ActorEntity> actorEntities = actorRepository.findAll();
		return new ResponseEntity<>(
				actorModelAssembler.toCollectionModel(actorEntities),
				HttpStatus.OK
		);
	}
	
	@GetMapping("/api/actors/{id}")
	public ResponseEntity<ActorModel> getActorById(@PathVariable("id") Long id) {
		return actorRepository.findById(id)
				.map(actorModelAssembler::toModel)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/api/albums")
	public ResponseEntity<CollectionModel<AlbumModel>> getAllAlbums() {
		List<AlbumEntity> albumsEntities = albumRepository.findAll();
		return new ResponseEntity<>(
				albumModelAssembler.toCollectionModel(albumsEntities),
				HttpStatus.OK
		);
	}
	
	@GetMapping("/api/albums/{id}")
	public ResponseEntity<AlbumModel> getAlbumById(@PathVariable("id") Long id) {
		return albumRepository.findById(id)
				.map(albumModelAssembler::toModel)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
}
