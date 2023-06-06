package com.masai.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tt")
	@SequenceGenerator(name = "tt",allocationSize = 1,initialValue = 000001)
	private String tconst;
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "titleType")
	private String titleType;
	@Column(name = "primaryTitle")
	private String primaryTitle;
	@Column(name = "runtimeMinutes")
	private Integer runtimeMinutes;
	@Column(name = "genres")
	private String genres;
	
}
