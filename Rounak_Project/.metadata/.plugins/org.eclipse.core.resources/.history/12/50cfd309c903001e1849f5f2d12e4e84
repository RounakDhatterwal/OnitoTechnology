package com.masai.service;

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

		List<Movies> movies = moviesRepo.findTop10ByOrderByRuntimeMinutes();
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
		List<MovieDTO> movies = moviesRepo.getMoviesWithAtLeastAverageRation();
		if (movies.isEmpty())
			throw new MoviesException("Movie not found in record");
		return movies;
	}

	@Override
	public List<MovieGenre> getListOfMoviesWithGenreWiseAndSubtotalOfNumVote() throws MoviesException {

		List<MovieGenre> movies = moviesRepo.getMovieGenreWithSubtotal();
		if (movies.isEmpty())
			throw new MoviesException("Movie not found in record");
		return movies;
	}

	@Override
	public String incrementRuntimeMinutesAsPerGenre() {
		Integer noOfRowAffected = moviesRepo.incrementRuntimeMinutesAsPerGenre();

		return "Updated...";
	}

}
