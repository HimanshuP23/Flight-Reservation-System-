package com.pojos;

import java.sql.Date;
import java.sql.Time;

public class flights {
	private int airlineId;
	private String airlineNumber;
	private String airlineName;
	private String departureCity;
	private String arrrivalCity;
	private Date departureDate;
	private Date arrivalDate;
	private Time departureTime;
	private Time arrivalTime;
	private int availableSeats;
	private float price;

	// default constructor
	public flights() {
		super();
		// TODO Auto-generated constructor stub
	}

	public flights(int airlineId, String airlineNumber, String airlineName, String departureCity, String arrrivalCity,
			Date departureDate, Date arrivalDate, Time departureTime, Time arrivalTime, int availableSeats,
			float price) {
		super();
		this.airlineId = airlineId;
		this.airlineNumber = airlineNumber;
		this.airlineName = airlineName;
		this.departureCity = departureCity;
		this.arrrivalCity = arrrivalCity;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.availableSeats = availableSeats;
		this.price = price;
	}
	
	// Getter and Setter
	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineNumber() {
		return airlineNumber;
	}

	public void setAirlineNumber(String airlineNumber) {
		this.airlineNumber = airlineNumber;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrrivalCity() {
		return arrrivalCity;
	}

	public void setArrrivalCity(String arrrivalCity) {
		this.arrrivalCity = arrrivalCity;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	

}
