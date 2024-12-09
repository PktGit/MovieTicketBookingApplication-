package com.movieTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieTicketBooking.entity.MovieEntity;

public interface MovieRepo extends JpaRepository<MovieEntity, Integer>{

	MovieEntity findByTitle(String title);

}
