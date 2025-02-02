package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// database connectivity
public class DbUtils {
	private static Connection connection;

	// creating a method for opening the connection
	public static void openConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/frs";
		connection = DriverManager.getConnection(dbURL, "root", "mysql");
	}

	// creating the method for getting the connection
	public static Connection getConnection() {
		return connection;
	}

	// creating method to close the connection when it is not required
	public static void closeConnection() throws SQLException {
		if (connection != null)
			connection.close();
	}

}
