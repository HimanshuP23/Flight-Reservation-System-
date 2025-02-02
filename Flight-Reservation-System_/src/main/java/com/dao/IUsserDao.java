package com.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.pojos.users;

public interface IUsserDao {
	String signUp(String fname, String lname, String email, String password,Date dob) throws SQLException;
	void cleanUp() throws SQLException;
	users login(String email, String password) throws SQLException;
}
