package com.dao;

import static com.utils.DbUtils.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojos.users;

public class UserDaoImpl implements IUsserDao {
	
	private Connection cn;
	private PreparedStatement pst1,pst2;
	public UserDaoImpl() throws SQLException{
		cn = getConnection();
		pst1 = cn.prepareStatement("insert into users values(default,?,?,?,?,?)");
		pst2 = cn.prepareStatement("Select * from users where email = ? and password = ?");
	}
	
	@Override
	public String signUp(String fname, String lname, String email, String password, Date dob) throws SQLException{
		// TODO Auto-generated method stub
		pst1.setString(1, fname);
		pst1.setString(2, lname);
		pst1.setString(3, email);
		pst1.setString(4, password);
		pst1.setDate(5, dob);
		int rowsCount = pst1.executeUpdate();
		if(rowsCount == 1)
			return "success";
		return "Failed to Register";
	}
	
	@Override
	public users login(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		pst2.setString(1, email);
		pst2.setString(2, password);
		// as this method will return the set of results hence we use result set 
		try(ResultSet rst = pst2.executeQuery()){
			if(rst.next()) {
				return new users(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),rst.getDate(6));
			}
 		}
		return null;
	}
	

	
	@Override
	public void cleanUp() throws SQLException{
		// TODO Auto-generated method stub
		if(pst1 != null)
			pst1.close();
	}
	
	
}
