package com.dao;

import java.sql.SQLException;

import com.pojos.reservation;

public interface IReservationDao {
	reservation bookingDetails(int rid) throws SQLException;

	int bookFlight(int pid, int fid, int paymentid) throws SQLException;
}
