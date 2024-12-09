package com.movieTicketBooking.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieTicketBooking.dto.MovieDto;
import com.movieTicketBooking.dto.TicketDto;
import com.movieTicketBooking.entity.MovieEntity;
import com.movieTicketBooking.entity.TicketEntity;
import com.movieTicketBooking.repository.MovieRepo;
import com.movieTicketBooking.repository.TicketRepo;
import com.movieTicketBooking.service.MovieService;

import dtoToEntityMapper.EntityToDTOMapper;
import dtoToEntityMapper.MovieDtoToEntityMapper;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepo movieRepo;
	private TicketRepo ticketRepo;
	
	@Override
	public MovieDto createNewMovie(MovieDto movie) {
		MovieEntity movieEntity = MovieDtoToEntityMapper.toEntity(movie);
		movieRepo.save(movieEntity);
		MovieDto movDto = EntityToDTOMapper.toDto(movieEntity);
		return movDto;
	}

	@Override
	public MovieDto getMovieById(int movieId) {
		MovieEntity movie = movieRepo.getById(movieId);
		MovieDto movDto = EntityToDTOMapper.toDto(movie);
		return movDto;
	}

//	@Override
//	public List<TicketDto> getAllMovieTickets(MovieDto mvDto) {
//		MovieEntity mEnity = MovieDtoToEntityMapper.toEntity(mvDto);
//		List<TicketEntity> tEntity = ticketRepo.findAllByMovie(mEnity.getId());
//		List<TicketDto> tDto = EntityToDTOMapper.toDto(tEntity);
//		return tDto;
//		
//	}
	
//	@Override
//	public List<TicketDto> getAllMovieTickets(MovieDto mvDto) {
//		MovieEntity mEnity = MovieDtoToEntityMapper.toEntity(mvDto);
//		List<TicketEntity> tEntity = ticketRepo.findAllByMovie(mEnity.getId());
//		List<TicketDto> tDto = EntityToDTOMapper.toDto(tEntity);
//		return tDto;
//		
//	}

	@Override
	public int findByName(String title) {
		List<MovieEntity> entityList =  new ArrayList<>();
		 return entityList.stream()
		            .filter(movie -> title.equals(movie.getTitle())) // Filter by title
		            .map(MovieEntity::getId)                        // Extract ID
		            .findFirst()                                    // Get the first match
		            .orElse(0);                                     // Return 0 if no match is found
	}

}
