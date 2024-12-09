package com.movieTicketBooking.service;

import java.util.List;

import com.movieTicketBooking.dto.MovieDto;
import com.movieTicketBooking.dto.TicketDto;

public interface TicketService {
	// bookMovieTicket() && getMovieTicketDetails
	
	public TicketDto bookMovieTicket(TicketDto ticketDto);
	public TicketDto getMovieTicketDetails(int ticketId);
	public List<TicketDto> getTicketsByMovieId(int movieID);
}
