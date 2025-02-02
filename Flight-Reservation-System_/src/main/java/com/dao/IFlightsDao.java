package com.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.pojos.flights;

public interface IFlightsDao {
	List<flights> searchFlights(String departureCity, String ArrivalCity, Date departureDate) throws SQLException;
	void cleanUp()throws SQLException;
	flights getFlightDetails(int flightId) throws SQLException;
}
