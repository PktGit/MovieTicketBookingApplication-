package dtoToEntityMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.movieTicketBooking.dto.MovieDto;
import com.movieTicketBooking.dto.TicketDto;
import com.movieTicketBooking.entity.MovieEntity;
import com.movieTicketBooking.entity.TicketEntity;

public class EntityToDTOMapper {
//	public static MovieDto toDto(MovieEntity entity) {
//		MovieDto movDto = new MovieDto();
//		movDto.setId(entity.getId());
//		movDto.setTitle(entity.getTitle());
//		movDto.setDirector(entity.getDirector());
//		movDto.setLanguage(entity.getLanguage());
//		movDto.setYear(entity.getYear());
//        return movDto;
//    }

	public static MovieDto toDto(MovieEntity movieEntity) {
		MovieDto movDto = new MovieDto();
		movDto.setId(movieEntity.getId());
		movDto.setTitle(movieEntity.getTitle());
		movDto.setDirector(movieEntity.getDirector());
		movDto.setLanguage(movieEntity.getLanguage());
		movDto.setYear(movieEntity.getYear());
        return movDto;
	}
	
	public static TicketDto toDto(TicketEntity ticketEntity) {
		TicketDto ticDto = new TicketDto();
		ticDto.setId(ticketEntity.getId());
		ticDto.setType(ticketEntity.getType());
		ticDto.setNoOfTickets(ticketEntity.getNo_of_ticket());
		ticDto.setUnitPrice(ticketEntity.getUnit_price());
		ticDto.setPrice(ticketEntity.getPrice());
		ticDto.setTitle(ticketEntity.getMovie().getTitle());
        return ticDto;
	}
	
//	public static List<TicketDto> toDto(List<TicketEntity> ticketEntity) {
//		List<TicketDto> ticDto = 
//		ticDto.setId(ticketEntity.getId());
//		ticDto.setType(ticketEntity.getType());
//		ticDto.setNoOfTickets(ticketEntity.getNo_of_ticket());
//		ticDto.setUnitPrice(ticketEntity.getUnit_price());
//		ticDto.setPrice(ticketEntity.getPrice());
//		ticDto.setTitle(ticketEntity.getMovie().getTitle());
//        return ticDto;
//	}
//	
	public static List<TicketDto> toDto(List<TicketEntity> ticketEntities) {
	    // Initialize an empty list to hold TicketDto objects
	    List<TicketDto> ticketDtos = new ArrayList<>();

	    // Iterate over each TicketEntity in the input list
	    for (TicketEntity ticketEntity : ticketEntities) {
	        // Create a new TicketDto object and set its fields
	        TicketDto ticketDto = new TicketDto();
	        ticketDto.setId(ticketEntity.getId());
	        ticketDto.setType(ticketEntity.getType());
	        ticketDto.setNoOfTickets(ticketEntity.getNo_of_ticket());
	        ticketDto.setUnitPrice(ticketEntity.getUnit_price());
	        ticketDto.setPrice(ticketEntity.getPrice());
	        ticketDto.setTitle(ticketEntity.getMovie().getTitle());

	        // Add the created TicketDto object to the result list
	        ticketDtos.add(ticketDto);
	    }

	    // Return the populated list of TicketDto objects
	    return ticketDtos;
	}

	
}
