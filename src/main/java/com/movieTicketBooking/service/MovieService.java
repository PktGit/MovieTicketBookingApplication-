package com.movieTicketBooking.service;


import com.movieTicketBooking.dto.MovieDto;

public interface MovieService {
	
	public MovieDto createNewMovie(MovieDto movie);
	public MovieDto getMovieById(int movieId);
	public int findByName(String title);

}
