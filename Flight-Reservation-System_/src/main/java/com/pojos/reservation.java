package com.pojos;

import java.sql.Date;
import java.sql.Time;

public class reservation {
	private int bookingId;
	private String name;
	private String flightNo;
	private String from;
	private String to;
	private Date departureDate;
	private Time departureTime;
	private int seatNo;
	private String airline;
	
	public reservation(String airline,int bookingId, String name, String flightNo, String from, String to, Date departureDate,
			Time departureTime, int seatNo) {
		super();
		this.airline = airline;
		this.bookingId = bookingId;
		this.name = name;
		this.flightNo = flightNo;
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.seatNo = seatNo;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	@Override
	public String toString() {
		return "Reservation [bookingId=" + bookingId + ", name=" + name + ", flightNo=" + flightNo + ", from=" + from
				+ ", to=" + to + ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", seatNo="
				+ seatNo + "]";
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public Date getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}


	public Time getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}


	public int getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

}
