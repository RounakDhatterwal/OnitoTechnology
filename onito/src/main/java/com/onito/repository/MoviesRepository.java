package com.onito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onito.entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies, String>{

}
