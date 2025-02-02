package com.pojos;

public class passengers {
	private int passengerId;
	private String passengerName;
	private String email;
	private String phone;
	
	// default constructor
	public passengers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public passengers(String passengerName, String email, String phone) {
		super();
		this.passengerName = passengerName;
		this.email = email;
		this.phone = phone;
	}
	
	
	public passengers(int passengerId, String passengerName, String email, String phone) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.email = email;
		this.phone = phone;
	}



	// Getter and Setter
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
