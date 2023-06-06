package com.masai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ratings {
	@Id
	private Long tconst;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tconst")
    private Movies movie;
	
	private Double averageRating;
	private Integer numVotes;
}
