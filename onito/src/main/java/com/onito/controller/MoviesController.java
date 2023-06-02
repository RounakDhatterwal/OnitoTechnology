package com.onito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onito.entity.Movies;
import com.onito.service.MoviesService;

import jakarta.validation.Valid;

@RestController("api/v1")
@CrossOrigin("*")
public class MoviesController {
	@Autowired
	private MoviesService movieService;

	@GetMapping("/longest-duration-movies")
	public ResponseEntity<List<Movies>> longestMovies(){
		List<Movies> list = movieService.top10MoviesWithLongestRunTime();
		return new ResponseEntity<List<Movies>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/new-movie")
	public ResponseEntity<String> addNewMovies(@Valid @RequestBody Movies movies){
		String movie = movieService.addMovies(movies);
		return new ResponseEntity<String>(movie, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/top-rated-movies")
	public ResponseEntity<List<Movies>> topRatedMovies(){
		List<Movies> list = movieService.moviesAbove6AverageRatingAndSortByAverageRating();
		return new ResponseEntity<List<Movies>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/genre-movies-with-subtotals")
	public ResponseEntity<List<Movies>> genreMoviesWithSubtotals(){
		List<Movies> list = movieService.moviesByGenreWise();
		return new ResponseEntity<List<Movies>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/update-runtime-minutes")
	public void updateRuntimeMinutes(){
		movieService.increaseRunTimeOfAllMovies();
	}
	
	
	
	
	
	
	
	
	
	
	
}
