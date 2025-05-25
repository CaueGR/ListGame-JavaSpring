package com.devrobattini.dslist.dto;

import com.devrobattini.dslist.entities.Game;
import com.devrobattini.dslist.projections.GameMinProjections;

public class GameMinDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjections projections) {
		id = projections.getId();
		title = projections.getTitle();
		year = projections.getGameYear();
		imgUrl = projections.getImgUrl();
		shortDescription = projections.getShortDescription();
	}
	

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
	
	
}
