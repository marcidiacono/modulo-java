package com.esolutions.microservice.models;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "album")
@JsonInclude(Include.NON_NULL)
@Relation(collectionRelation = "albums")
public class AlbumModel extends RepresentationModel<AlbumModel> {
	
	private Long id;
	private String title;
	private String description;
	private String releaseDate;
	
	private List<ActorModel>actors;

}
