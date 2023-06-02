package com.onito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onito.entity.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings, String>{

}
