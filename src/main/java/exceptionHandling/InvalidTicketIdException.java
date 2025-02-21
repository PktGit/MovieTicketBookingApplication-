package exceptionHandling;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidTicketIdException extends RuntimeException {
    public InvalidTicketIdException(String message) {
        super(message);
    }
}