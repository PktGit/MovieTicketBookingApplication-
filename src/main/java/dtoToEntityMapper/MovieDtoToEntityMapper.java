package dtoToEntityMapper;

import com.movieTicketBooking.dto.MovieDto;
import com.movieTicketBooking.entity.MovieEntity;

public class MovieDtoToEntityMapper {
	public static MovieEntity toEntity(MovieDto dto) {
        MovieEntity entity = new MovieEntity();
        entity.setTitle(dto.getTitle());
        entity.setDirector(dto.getDirector());
        entity.setLanguage(dto.getLanguage());
        entity.setYear(dto.getYear());
        return entity;
    }
}
