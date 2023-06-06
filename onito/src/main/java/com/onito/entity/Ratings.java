package com.onito.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {

	@Id
	private Long tconst;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tconst")
	private Movies movie;
	
	private double averageRating;
	private Integer numVotes;
}
