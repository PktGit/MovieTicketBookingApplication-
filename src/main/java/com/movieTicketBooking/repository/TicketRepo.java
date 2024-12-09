package com.movieTicketBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieTicketBooking.entity.MovieEntity;
import com.movieTicketBooking.entity.TicketEntity;

public interface TicketRepo extends JpaRepository<TicketEntity, Integer> {

	public List<TicketEntity> findByMovie_Id(int movieID);

}
