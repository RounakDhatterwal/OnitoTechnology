package com.onito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onito.DTO.MovieDTO;
import com.onito.DTO.MovieGenre;
import com.onito.entity.Movies;
import com.onito.exception.MovieException;
import com.onito.repository.MoviesRepository;

@Service
public class MoviesServiceImplementation implements MoviesService{

	@Autowired
	private MoviesRepository moviesrepo;
	
	@Override
	public List<Movies> top10MoviesWithLongestRunTime() throws MovieException {
		// TODO Auto-generated method stub
		List<Movies> top10movies = moviesrepo.findTop10ByOrderByRuntimeMinutes();
		if(top10movies.isEmpty()) {
			throw new MovieException("Movie not found in record");
		}
		return top10movies;
	}

	@Override
	public String addMovies(Movies movie) throws MovieException {
		if(movie == null) {
			throw new MovieException("Movie data inserted incorrectly");
		}
		moviesrepo.save(movie);
		return "success";
	}

	@Override
	public List<MovieDTO> moviesAbove6AverageRatingAndSortByAverageRating() throws MovieException {
		// TODO Auto-generated method stub

		List<MovieDTO> avgmovies = moviesrepo.getMoviesWithAtLeastAverageRation();
		if(avgmovies.isEmpty()) {
			throw new MovieException("Movie not found in record");
		}

		return avgmovies;
	}

	@Override
	public List<MovieGenre> moviesByGenreWise() throws MovieException {
		List<MovieGenre> genmovies = moviesrepo.getMovieGenreWithSubtotal();
		if(genmovies.isEmpty()) {
			throw new MovieException("Movie not found in record");
		}
		return genmovies;
	}

	@Override
	public String increaseRunTimeOfAllMovies() throws MovieException {
		// TODO Auto-generated method stub
		Integer noOfRowsAffected = moviesrepo.incrementRuntimeMinutesAsPerGenre();
		
		return "Updated....";
	}

}
