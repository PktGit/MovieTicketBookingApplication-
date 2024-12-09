package com.movieTicketBooking.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Ticket_Entity")

public class TicketEntity {
	
	/*id: Primary key, automatically generated.
type: The type of ticket, not null.
unit_price: The unit price of a ticket, not null.
no_of_tickets: The number of tickets purchased, not null.
price: The total price of the tickets, not null.
movie_id: Foreign key referencing id in MovieEntity to establish a many-to-one relationship.*/
	@Id
	@Column(name = "ticket_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "type", nullable = false)
	private String type;
	@Column(name = "unit_price", nullable = false)
	private int unit_price;
	@Column(name = "no_of_tickets", nullable = false)
	private int no_of_ticket;
	@Column(name = "price", nullable = false)
	private int price;
	
	@ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}

	public int getNo_of_ticket() {
		return no_of_ticket;
	}

	public void setNo_of_ticket(int no_of_ticket) {
		this.no_of_ticket = no_of_ticket;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "TicketEntity [id=" + id + ", type=" + type + ", unit_price=" + unit_price + ", no_of_ticket="
				+ no_of_ticket + ", price=" + price + ", movie=" + movie + "]";
	}

	public TicketEntity(int id, String type, int unit_price, int no_of_ticket, int price, MovieEntity movie) {
		super();
		this.id = id;
		this.type = type;
		this.unit_price = unit_price;
		this.no_of_ticket = no_of_ticket;
		this.price = price;
		this.movie = movie;
	}

	public TicketEntity() {
		super();
	}
	
	
	

}
