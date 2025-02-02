package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import com.pojos.cards;
import java.sql.*;

import static com.utils.DbUtils.*;

public class PassengerDaoImpl implements IPassengersDao{
	
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4;
	
	public PassengerDaoImpl() throws SQLException{
		cn = getConnection();
		pst1 = cn.prepareStatement("Insert into passengers values(default,?,?,?)");
		pst2 = cn.prepareStatement("select id from passengers where passenger_name=? and email=?");
		pst3 = cn.prepareStatement("insert into cards values(default,?,?,?,?)");
		pst4 = cn.prepareStatement("select payment_id from cards where card_no=? and card_name =?");
	}
	
	@Override
	public int addPassenger(String passengerName, String email, String phoneNo) throws SQLException {
		pst1.setString(1, passengerName);
		pst1.setString(2, email);
		pst1.setString(3, phoneNo);
		
		int rowsCount = pst1.executeUpdate();
		if(rowsCount == 1)
			return getPassengerId(passengerName,email);
		return 0;

	}
	
	@Override
	public int getPassengerId(String name, String email) throws SQLException {
		pst2.setString(1, name);
		pst2.setString(2, email);
		try(ResultSet rst = pst2.executeQuery()){
			if(rst.next())
				return rst.getInt(1);
		}
		return 0;
	}
	
	@Override
	public int makePayment(cards card) throws SQLException {
		// TODO Auto-generated method stub
		pst3.setString(1, card.getCardNumber());
		pst3.setString(2,card.getCardName());
		pst3.setDate(3, card.getExpiryDate());
		pst3.setInt(4, card.getCvv());
		int rows = pst3.executeUpdate();
		if(rows==1)
			return getPaymentId(card.getCardNumber(),card.getCardName());
		return 0;
	}
	
	private int getPaymentId(String cardno, String cardname) throws SQLException {
		// TODO Auto-generated method stub
		pst4.setString(1, cardno);
		pst4.setString(2, cardname);
		try(ResultSet rs = pst4.executeQuery()){
			if(rs.next())
				return rs.getInt(1);
		}
		return 0;
	}
	
}
