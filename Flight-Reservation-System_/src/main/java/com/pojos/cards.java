package com.pojos;

import java.sql.Timestamp;
import java.sql.Date;

public class cards {
	private int paymentId;
	private String cardNumber;
	private String cardName;
	private Date expiryDate;
	private int cvv;
	private Timestamp paymentDateTime;

	// Default constructor
	public cards() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public cards(String cardNumber, String cardName, Date expiryDate, int cvv) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}



	// Getter and Setter
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Timestamp getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(Timestamp paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

}
