package dtoToEntityMapper;



import com.movieTicketBooking.dto.TicketDto;
import com.movieTicketBooking.entity.MovieEntity;
import com.movieTicketBooking.entity.TicketEntity;


public class TicketDtoToEntityMapper {
	
	
	public static TicketEntity toEntity(TicketDto dto, MovieEntity meEntity) {
		

		TicketEntity entity = new TicketEntity();
		entity.setType(dto.getType());
		entity.setUnit_price(dto.getUnitPrice());
		entity.setNo_of_ticket(dto.getNoOfTickets());
		entity.setPrice(dto.getNoOfTickets()*dto.getUnitPrice());
		entity.setMovie(meEntity);
        return entity;
    }

}
