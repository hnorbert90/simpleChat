package com.simpleChat.Chat.controllers;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect extends DB {
	
	public void connectToDatabase()  {
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				connect = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}

	public static void close() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
		}
	}
}
