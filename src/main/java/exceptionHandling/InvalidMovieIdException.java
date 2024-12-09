package exceptionHandling;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidMovieIdException extends RuntimeException {
    public InvalidMovieIdException(String message) {
        super(message);
    }
}

