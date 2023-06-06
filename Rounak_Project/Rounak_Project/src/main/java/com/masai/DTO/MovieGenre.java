package com.masai.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieGenre {

	private String genre;
	private String primaryTitle;
	private Long numVotes;
}