package com.masai.service;

import java.util.List;

import com.masai.DTO.MovieDTO;
import com.masai.DTO.MovieGenre;
import com.masai.entity.Movies;
import com.masai.exceptions.MoviesException;

public interface MoviesService {

	public List<Movies> getTopTenMoviesWithLongestRuntime() throws MoviesException;
	
	public String addNewMovie(Movies movies) throws MoviesException;
	
	public List<MovieDTO> getMoviesWithAtLeastAverageRation() throws MoviesException;
	
	public List<MovieGenre> getListOfMoviesWithGenreWiseAndSubtotalOfNumVote() throws MoviesException;
	
	public String incrementRuntimeMinutesAsPerGenre();
}
