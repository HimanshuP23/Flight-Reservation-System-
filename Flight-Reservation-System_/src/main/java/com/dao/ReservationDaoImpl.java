package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.utils.DbUtils.*;
import com.pojos.reservation;

public class ReservationDaoImpl implements IReservationDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4;
	public ReservationDaoImpl() throws SQLException{
		// TODO Auto-generated constructor stub
		cn = getConnection();
		pst1 = cn.prepareStatement("Insert into reservation values(default,?,?,?)");
		pst2 = cn.prepareStatement("Select booking_id from reservation where passenger_id=? and flight_id=?");
		pst3 = cn.prepareStatement("select booking_id ,p.passenger_name, f.airline_number,f.departure_city,f.arrival_city,f.departure_date,f.departure_time,f.available_seats,f.airline_name from reservation r inner join passengers p on r.passenger_id=p.id inner join flights f on r.flight_id=f.airline_id where r.booking_id=?");
		pst4 = cn.prepareStatement("Update flights set available_seats=available_seats-1 where airline_id=?");
	}
	
	public int getBookingId(int pid,int fid) throws SQLException {
		pst2.setInt(1, pid);
		pst2.setInt(2,fid);
		try(ResultSet rs = pst2.executeQuery()){
			if(rs.next()) {
				return rs.getInt(1);
			}
		}
		return 0;
	}
	
	
	
	@Override
	public int bookFlight(int pid,int fid,int paymentid) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("fid"+fid);
		pst1.setInt(1, pid);
		pst1.setInt(2, fid);
		pst1.setInt(3, paymentid);
		int rows = pst1.executeUpdate();
		
		pst4.setInt(1, fid);
		int r = pst4.executeUpdate();
		System.out.println("seats"+r);
		if(rows == 1)
			return getBookingId(pid, fid);
		return 0;
	}

	@Override
	public reservation bookingDetails(int rid) throws SQLException{
		pst3.setInt(1, rid);
		try(ResultSet rst = pst3.executeQuery()){
			if(rst.next()) {
				return new reservation(rst.getString(9),rid, rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getDate(6), rst.getTime(7), rst.getInt(8));
			}
		}
		return null;
	}

}
