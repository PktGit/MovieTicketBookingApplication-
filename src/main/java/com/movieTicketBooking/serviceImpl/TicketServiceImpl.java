package com.movieTicketBooking.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieTicketBooking.dto.TicketDto;
import com.movieTicketBooking.entity.MovieEntity;
import com.movieTicketBooking.entity.TicketEntity;
import com.movieTicketBooking.repository.MovieRepo;
import com.movieTicketBooking.repository.TicketRepo;
import com.movieTicketBooking.service.TicketService;

import dtoToEntityMapper.EntityToDTOMapper;
import dtoToEntityMapper.TicketDtoToEntityMapper;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepo ticketrepo;
	private MovieRepo movieRepo;

	public TicketServiceImpl(TicketRepo ticketrepo, MovieRepo movieRepo) {
		super();
		this.ticketrepo = ticketrepo;
		this.movieRepo = movieRepo;
	}

	@Override
	public TicketDto bookMovieTicket(TicketDto ticket) {
		MovieEntity mEntity = movieRepo.findByTitle(ticket.getTitle());
		TicketEntity ticketEntity = TicketDtoToEntityMapper.toEntity(ticket, mEntity);
		ticketrepo.save(ticketEntity);
		TicketDto tDto = EntityToDTOMapper.toDto(ticketEntity); 
		return tDto;
	}

	@Override
	public TicketDto getMovieTicketDetails(int ticketId) {
		TicketEntity ticketEnt = ticketrepo.getById(ticketId);
		TicketDto tDto = EntityToDTOMapper.toDto(ticketEnt);
		return tDto;
		
	}

	@Override
	public List<TicketDto> getTicketsByMovieId(int movieID) {
		List<TicketEntity> ticketEntities = ticketrepo.findByMovie_Id(movieID);
		List<TicketDto> tDto = EntityToDTOMapper.toDto(ticketEntities);
		return tDto;
	}

	

}
