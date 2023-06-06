package com.masai.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.MovieDTO;
import com.masai.DTO.MovieGenre;
import com.masai.entity.Movies;
import com.masai.exceptions.MoviesException;
import com.masai.repository.MoviesRepository;

@Service
public class MoviesServiceImpl implements MoviesService {
	@Autowired
	private MoviesRepository moviesRepo;

//	his route returns as JSON the top 10 movies with the longest runTime
//	The output should contain tconst, primaryTitle, runtimeMinutes & genres

	@Override
	public List<Movies> getTopTenMoviesWithLongestRuntime() throws MoviesException {

		List<Movies> movies = moviesRepo.findTop10ByOrderByRuntimeMinutesDesc();
		if (movies.isEmpty())
			throw new MoviesException("Movie not found in record");
		return movies;
	}

	@Override
	public String addNewMovie(Movies movies) throws MoviesException {
		if (movies == null)
			throw new MoviesException("Movie Details is Necessary!");
		Movies m = moviesRepo.save(movies);
		if (m == null)
			if (movies == null)
				throw new MoviesException("Movie Details is Necessary!");
		return "success";
	}

	@Override
	public List<MovieDTO> getMoviesWithAtLeastAverageRation() throws MoviesException {
		List<Object[]> obj = moviesRepo.getMoviesWithAtLeastAverageRation();
		if (obj.isEmpty())
			throw new MoviesException("Movie not found in record");
		List<MovieDTO> movies = new ArrayList<>();
		for(Object[] arr : obj) {
			movies.add(new MovieDTO( (String) arr[0], (String) arr[1],(String) arr[2],(Double) arr[3]));
		}
		return movies;
	}

	@Override
	public List<MovieGenre> getListOfMoviesWithGenreWiseAndSubtotalOfNumVote() throws MoviesException {
		List<Object[]> obj = moviesRepo.getMovieGenreWithSubtotal();
		if (obj.isEmpty())
			throw new MoviesException("Movie not found in record");
		List<MovieGenre> movies = new ArrayList<>(); 
		for(Object[] arr : obj) {
			movies.add(new MovieGenre( (String) arr[0], (String) arr[1],(Long) arr[2]));
		}
		return movies;
	}

	@Override
	public String incrementRuntimeMinutesAsPerGenre() {
		moviesRepo.incrementRuntimeMinutesAsPerGenre();

		return "Updated...";
	}

}
