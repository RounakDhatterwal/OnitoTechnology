package com.onito.service;

import java.util.List;

import com.onito.entity.Movies;

public interface MoviesService {
	public List<Movies> top10MoviesWithLongestRunTime();
	public String addMovies(Movies movie);
	public List<Movies> moviesAbove6AverageRatingAndSortByAverageRating();
	public List<Movies> moviesByGenreWise();
	public void increaseRunTimeOfAllMovies();
}
