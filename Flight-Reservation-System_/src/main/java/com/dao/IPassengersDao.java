package com.dao;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.pojos.cards;
import com.pojos.passengers;

public interface IPassengersDao {
	int addPassenger(String passengerName, String email, String phoneNo) throws SQLException;
	int getPassengerId(String name, String email) throws SQLException;
	int makePayment(cards card) throws SQLException;
	
}
