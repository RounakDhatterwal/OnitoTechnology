package com.onito.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movies {

	@Id
	private String tconst;
	private String titleType;
	private String primaryTitle;
	private int runtimeMinutes;
	private String genres;
	
}
