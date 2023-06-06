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

import com.onito.DTO.MovieDTO;
import com.onito.DTO.MovieGenre;
import com.onito.entity.Movies;
import com.onito.exception.MovieException;
import com.onito.service.MoviesService;

import jakarta.validation.Valid;

@RestController()
@CrossOrigin("*")
public class MoviesController {
	@Autowired
	private MoviesService movieService;

	@GetMapping("/api/v1/longest-duration-movies")
	public ResponseEntity<List<Movies>> longestMovies() throws MovieException{
		List<Movies> list = movieService.top10MoviesWithLongestRunTime();
		return new ResponseEntity<List<Movies>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/api/v1/new-movie")
	public ResponseEntity<String> addNewMovies(@Valid @RequestBody Movies movies) throws MovieException{
		String movie = movieService.addMovies(movies);
		return new ResponseEntity<String>(movie, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/api/v1/top-rated-movies")
	public ResponseEntity<List<MovieDTO>> topRatedMovies() throws MovieException{
		List<MovieDTO> list = movieService.moviesAbove6AverageRatingAndSortByAverageRating();
		return new ResponseEntity<List<MovieDTO>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/api/v1/genre-movies-with-subtotals")
	public ResponseEntity<List<MovieGenre>> genreMoviesWithSubtotals() throws MovieException{
		List<MovieGenre> list = movieService.moviesByGenreWise();
		return new ResponseEntity<List<MovieGenre>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/api/v1/update-runtime-minutes")
	public ResponseEntity<String> updateRuntimeMinutes() throws MovieException{
		String str = movieService.increaseRunTimeOfAllMovies();
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
