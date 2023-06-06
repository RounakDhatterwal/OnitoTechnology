package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.MovieDTO;
import com.masai.DTO.MovieGenre;
import com.masai.entity.Movies;
import com.masai.exceptions.MoviesException;
import com.masai.service.MoviesService;

import jakarta.validation.Valid;

@RestController()
@CrossOrigin("*")
public class MoviesController {
	@Autowired
	private MoviesService movieService;

	@GetMapping("/api/v1/longest-duration-movies")
	public ResponseEntity<List<Movies>> longestMovies() throws MoviesException{
		List<Movies> list = movieService.getTopTenMoviesWithLongestRuntime();
		return new ResponseEntity<List<Movies>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/api/v1/new-movie")
	public ResponseEntity<String> addNewMovies(@Valid @RequestBody Movies movies) throws MoviesException{
		String movie = movieService.addNewMovie(movies);
		return new ResponseEntity<String>(movie, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/api/v1/top-rated-movies")
	public ResponseEntity<List<MovieDTO>> topRatedMovies() throws MoviesException{
		List<MovieDTO> list = movieService.getMoviesWithAtLeastAverageRation();
		return new ResponseEntity<List<MovieDTO>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/api/v1/genre-movies-with-subtotals")
	public ResponseEntity<List<MovieGenre>> genreMoviesWithSubtotals() throws MoviesException{
		List<MovieGenre> list = movieService.getListOfMoviesWithGenreWiseAndSubtotalOfNumVote();
		return new ResponseEntity<List<MovieGenre>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/api/v1/update-runtime-minutes")
	public ResponseEntity<String> updateRuntimeMinutes() throws MoviesException{
		String str = movieService.incrementRuntimeMinutesAsPerGenre();
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
