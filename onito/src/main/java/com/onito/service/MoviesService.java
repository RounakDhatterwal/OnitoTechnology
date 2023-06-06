package com.onito.service;

import java.util.List;

import com.onito.DTO.MovieDTO;
import com.onito.DTO.MovieGenre;
import com.onito.entity.Movies;
import com.onito.exception.MovieException;

public interface MoviesService {
	public List<Movies> top10MoviesWithLongestRunTime() throws MovieException;
	public String addMovies(Movies movie) throws MovieException;
	public List<MovieDTO> moviesAbove6AverageRatingAndSortByAverageRating() throws MovieException;
	public List<MovieGenre> moviesByGenreWise() throws MovieException;
	public String increaseRunTimeOfAllMovies() throws MovieException;
}
