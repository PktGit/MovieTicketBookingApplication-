package com.movieTicketBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieTicketBooking.dto.MovieDto;
import com.movieTicketBooking.dto.TicketDto;
import com.movieTicketBooking.entity.MovieEntity;
import com.movieTicketBooking.service.MovieService;
import com.movieTicketBooking.service.TicketService;

import exceptionHandling.InvalidMovieIdException;
import exceptionHandling.InvalidTicketIdException;

@RestController
@RequestMapping("/theater")
public class MovieTicketController {
	
//	@Autowired
//	private MovieService movieService;
//	
//	@Autowired
//	private TicketService ticketService;
//	
//	@PostMapping("/movie")
//	public MovieDto createNewMovie(@RequestBody MovieDto movie) {
//		return movieService.createNewMovie(movie);
//		 
//	}
//	
//	@PostMapping("/movie/ticket/booking")
//	public TicketDto bookMovieTicket(@RequestBody TicketDto ticketDto) {
//		return ticketService.bookMovieTicket(ticketDto);
//	}
//	
//	@GetMapping("/movie/{movieId}")
//	public MovieDto getMovieDetails(@PathVariable int movieId) {
//		return movieService.getMovieById(movieId);
//	}
//	
//	@GetMapping("/movie/ticket/booking/{ticketId}")
//	public TicketDto getMovieTicketDetails(@PathVariable int ticketId) {
//		return ticketService.getMovieTicketDetails(ticketId);
//	}
//	@GetMapping("/movie/{movieID}/ticket")
//	public List<TicketDto> getAllMovieTickets(@PathVariable int movieID){
//		 List<TicketDto> tickets = ticketService.getTicketsByMovieId(movieID);
//		return tickets;
//	}
	
	@Autowired
    private MovieService movieService;

    @Autowired
    private TicketService ticketService;

    // Create a new movie
    @PostMapping("/movie")
    public ResponseEntity<?> createNewMovie(@RequestBody MovieDto movie) {
        try {
            MovieDto createdMovie = movieService.createNewMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create movie: " + e.getMessage());
        }
    }

    // Book a movie ticket
    @PostMapping("/movie/ticket/booking")
    public ResponseEntity<?> bookMovieTicket(@RequestBody TicketDto ticketDto) {
        try {
            TicketDto bookedTicket = ticketService.bookMovieTicket(ticketDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookedTicket);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to book ticket: " + e.getMessage());
        }
    }

    // Get movie details by ID
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<?> getMovieDetails(@PathVariable int movieId) {
        try {
            MovieDto movie = movieService.getMovieById(movieId);
            if (movie == null) {
                throw new InvalidMovieIdException("Movie with ID " + movieId + " not found.");
            }
            return ResponseEntity.ok(movie);
        } catch (InvalidMovieIdException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to fetch movie details: " + e.getMessage());
        }
    }

    // Get movie ticket details by ID
    @GetMapping("/movie/ticket/booking/{ticketId}")
    public ResponseEntity<?> getMovieTicketDetails(@PathVariable int ticketId) {
        try {
            TicketDto ticket = ticketService.getMovieTicketDetails(ticketId);
            if (ticket == null) {
                throw new InvalidTicketIdException("Ticket with ID " + ticketId + " not found.");
            }
            return ResponseEntity.ok(ticket);
        } catch (InvalidTicketIdException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to fetch ticket details: " + e.getMessage());
        }
    }

    // Get all tickets for a movie by movie ID
    @GetMapping("/movie/{movieID}/ticket")
    public ResponseEntity<?> getAllMovieTickets(@PathVariable int movieID) {
        try {
            List<TicketDto> tickets = ticketService.getTicketsByMovieId(movieID);
            if (tickets.isEmpty()) {
                throw new InvalidMovieIdException("No tickets found for Movie ID " + movieID);
            }
            return ResponseEntity.ok(tickets);
        } catch (InvalidMovieIdException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to fetch tickets: " + e.getMessage());
        }
    }
	
	

}
