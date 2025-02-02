package com.dao;

import static com.utils.DbUtils.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.pojos.flights;


public class flightsDaoImpl implements IFlightsDao{
	private Connection cn;
	private PreparedStatement pst1,pst2;
	// create a constructor to open connection and adding of sql queries
	public flightsDaoImpl() throws SQLException {
		cn = getConnection();
		pst1 = cn.prepareStatement("select * from flights where departure_city = ? and arrival_city=? and departure_date=?");
		pst2 = cn.prepareStatement("select * from flights where airline_id=? ");
	}
	
	@Override
	public List<flights> searchFlights(String departureCity, String ArrivalCity, Date departureDate)
			throws SQLException {
		// TODO Auto-generated method stub
		pst1.setString(1, departureCity);
		pst1.setString(2, ArrivalCity);
		pst1.setDate(3, departureDate);
		List<flights> flightsList = new ArrayList<>();
		try(ResultSet rst = pst1.executeQuery()){
			while(rst.next()) {
//				int airlineId, String airlineNumber, String airlineName, String departureCity, String arrrivalCity,
//				Date departureDate, Date arrivalDate, Time departureTime, Time arrivalTime, int availableSeats,
//				float price
				flightsList.add(new flights(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getString(4), rst.getString(5), rst.getDate(6), rst.getDate(7),
						rst.getTime(8),rst.getTime(9),rst.getInt(10), rst.getFloat(11)));
			}
		}
		return flightsList;
	}
	
	@Override
	public flights getFlightDetails(int flightId) throws SQLException {
		// TODO Auto-generated method stub
		pst2.setInt(1, flightId);
		try(ResultSet rst = pst2.executeQuery()){
			if(rst.next()) {
				return new flights(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getString(4), rst.getString(5), rst.getDate(6), rst.getDate(7),
						rst.getTime(8),rst.getTime(9),rst.getInt(10), rst.getFloat(11));
			}
		}
		System.out.println("got flight details");
		return null;
	}
	
	@Override
	public void cleanUp() throws SQLException{
		// TODO Auto-generated method stub
		if(pst1 != null)
			pst1.close();
	}
	
	
}
