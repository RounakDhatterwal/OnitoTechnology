package com.onito.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ratings {

	@Id
	private String tconst;
	private double averageRating;
	private int numVotes;
}
