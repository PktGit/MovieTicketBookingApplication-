package com.movieTicketBooking.dto;

public class MovieDto {
	private int id;
	private String title;
	private String director;
	private String language;
	private int year;
	
	

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

	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", title=" + title + ", director=" + director + ", language=" + language + ", year=" + year
				+ "]";
	}

	public MovieDto(int id, String title, String director, String language, int year) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.language = language;
		this.year = year;
	}

	public MovieDto() {
		super();
	}

}
