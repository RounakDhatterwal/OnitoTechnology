package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.DTO.MovieDTO;
import com.masai.DTO.MovieGenre;
import com.masai.entity.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {

	@Query("SELECT m.genres AS genre, m.primaryTitle, SUM(r.numVotes) AS numVotes "
            + "FROM Movies m JOIN Ratings r ON m.tconst = r.tconst "
            + "GROUP BY ROLLUP (m.genres, m.primaryTitle) ")
    public List<MovieGenre> getMovieGenreWithSubtotal();
	
	public List<Movies> findTop10ByOrderByRuntimeMinutes();

	@Query("SELECT m.tconst, m.primaryTitle, m.genres, r.averageRating FROM Movies m JOIN FETCH Ratings r ON m.tconst = r.tconst WHERE r.averageRating > 6.0 order by r.averageRating Asc")
	public List<MovieDTO> getMoviesWithAtLeastAverageRation();

	@Modifying
	@Query("UPDATE Movies SET runtimeMinutes = "
			+ "CASE"
			+ "    WHEN genres = 'Documentary' THEN runtimeMinutes + 15"
			+ "    WHEN genres = 'Animation' THEN runtimeMinutes + 30"
			+ "    ELSE runtimeMinutes + 45"
			+ "END")
	public int incrementRuntimeMinutesAsPerGenre();
}
