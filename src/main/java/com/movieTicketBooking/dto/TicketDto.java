package com.movieTicketBooking.dto;

public class TicketDto {
	
	private int id;
	private String title;
	private String type;
	private int unitPrice;
	private int noOfTickets;
	private int price;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TicketDto [title=" + title + ", type=" + type + ", unitPrice=" + unitPrice + ", noOfTickets="
				+ noOfTickets + ", price=" + price + "]";
	}

	public TicketDto(String title, String type, int unitPrice, int noOfTickets, int price) {
		super();
		this.title = title;
		this.type = type;
		this.unitPrice = unitPrice;
		this.noOfTickets = noOfTickets;
		this.price = price;
	}

	public TicketDto() {
		super();
	}

}
