package com.simpleChat.Chat.controllers;

import java.sql.SQLException;

public class DatabaseController extends Connect {

	public void sendMessage(String username, String message, Connect _conn) {
		connectToDatabase(_conn);
		try {
			preparedStatement = connect
					.prepareStatement("insert into " + getDatabase() + "." + getTable() + " values (?, ?)");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, message);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getMessages(Connect _conn) {
		connectToDatabase(_conn);
		doQuery();
		return getString();

	}

	private String getString() {
		String cache = "";
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				cache += resultSet.getString("username") + " : " + resultSet.getString("message") + "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cache;
	}

	private void doQuery() {
		try {
			preparedStatement = connect
					.prepareStatement("SELECT * FROM " + super.getDatabase() + "." + super.getTable() + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void connectToDatabase(Connect _conn) {
		Connect conn = _conn;
		conn.connectToDatabase();
	}
}
