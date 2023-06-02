package com.onito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onito.entity.Movies;
import com.onito.repository.MoviesRepository;
import com.onito.repository.RatingsRepository;

@Service
public class MoviesServiceImplementation implements MoviesService{

	@Autowired
	private MoviesRepository moviesrepo;
	
	@Autowired
	private RatingsRepository ratingrepo;
	
	@Override
	public List<Movies> top10MoviesWithLongestRunTime() {
		// TODO Auto-generated method stub
		List<Movies> allmovies = moviesrepo.findAll();
		List<Movies> top10movies = new ArrayList<>();
		for(int i=0; i<10; i++) {
			top10movies.add(allmovies.get(i));
		}
		return top10movies;
	}

	@Override
	public String addMovies(Movies movie) {
		moviesrepo.save(movie);
		return "Movie added sucessfully";
	}

	@Override
	public List<Movies> moviesAbove6AverageRatingAndSortByAverageRating() {
		// TODO Auto-generated method stub
		List<Movies> allmovies = moviesrepo.findAll();
		List<Movies> avgmovies = new ArrayList<>();
		for(Movies m : allmovies) {
		
		}
		return avgmovies;
	}

	@Override
	public List<Movies> moviesByGenreWise() {
		// TODO Auto-generated method stub
		List<Movies> allmovies = moviesrepo.findAll();
		List<Movies> avgmovies = new ArrayList<>();
		
		return null;
	}

	@Override
	public void increaseRunTimeOfAllMovies() {
		// TODO Auto-generated method stub
		
	}

}
