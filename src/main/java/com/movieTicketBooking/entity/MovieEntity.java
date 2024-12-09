package com.movieTicketBooking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Movie_Entity")
public class MovieEntity {

	/*
	 * MOVIE_ENTITY:
	 * 
	 * id: Primary key, automatically generated. title: The title of the movie, not
	 * null. director: The director of the movie, not null. language: The language
	 * of the movie, not null. release_year: The release year of the movie, not null
	 * (mapped from year field in the entity).
	 */
	@Id
	@Column(name = "MovieId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "director", nullable = false)
	private String director;
	@Column(name = "language", nullable = false)
	private String language;
	@Column(name = "date", nullable = false)
	private int year;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<TicketEntity> tickets;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<TicketEntity> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketEntity> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "MovieEntity [id=" + id + ", title=" + title + ", director=" + director + ", language=" + language
				+ ", dt=" + year + ", tickets=" + tickets + "]";
	}

	public MovieEntity(int id, String title, String director, String language, int year, List<TicketEntity> tickets) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.language = language;
		this.year = year;
		this.tickets = tickets;
	}

	public MovieEntity() {
		super();
	}
	
	
	

}
