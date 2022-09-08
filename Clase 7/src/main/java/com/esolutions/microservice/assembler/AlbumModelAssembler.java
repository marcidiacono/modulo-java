package com.esolutions.microservice.assembler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.esolutions.microservice.controllers.WebController;
import com.esolutions.microservice.models.ActorEntity;
import com.esolutions.microservice.models.ActorModel;
import com.esolutions.microservice.models.AlbumEntity;
import com.esolutions.microservice.models.AlbumModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AlbumModelAssembler extends 
	RepresentationModelAssemblerSupport<AlbumEntity, AlbumModel>{
	
	public AlbumModelAssembler() {
		super(WebController.class, AlbumModel.class);
	}

	@Override
	public AlbumModel toModel(AlbumEntity entity) {
		AlbumModel albumModel = instantiateModel(entity);
		albumModel.add(linkTo(
				methodOn(WebController.class)
				.getAlbumById(entity.getId()))
				.withSelfRel());
		
		albumModel.setId(entity.getId());
		albumModel.setTitle(entity.getTitle());
		albumModel.setDescription(entity.getDescription());
		albumModel.setReleaseDate(entity.getReleaseDate());
		albumModel.setActors(toActorModel(entity.getActors()));
		return albumModel;
	}
	
	@Override
	public CollectionModel<AlbumModel> toCollectionModel(Iterable<? extends AlbumEntity> entities) {
		CollectionModel<AlbumModel> albumModels = super.toCollectionModel(entities);
		albumModels.add(linkTo(methodOn(WebController.class).getAllAlbums()).withSelfRel());
		return albumModels;
	}
	
	
	private List<ActorModel> toActorModel(List<ActorEntity> actors) {
		if (actors.isEmpty()) {
			return Collections.emptyList();
		}
		return actors.stream()
				.map(actor -> ActorModel.builder()
								.id(actor.getId())
								.firstName(actor.getFirstName())
								.lastName(actor.getLastName())
								.birthDate(actor.getBirthDate())
								.build()
								.add(linkTo(
										methodOn(WebController.class)
										.getActorById(actor.getId()))
										 	.withSelfRel()))
				.collect(Collectors.toList());
					
	}
	
}
