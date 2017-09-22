package com.simpleChat.Chat.controllers;

import java.sql.SQLException;
import java.util.Collections;

import com.simpleChat.Chat.modell.ChatModell;

public class DatabaseController extends Connect {
	static Connect conn;
	
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
		}finally{
			conn.close();
		}
	}

	public void getMessages(Connect _conn) {
		connectToDatabase(_conn);
		doQuery();
		getString();
	}

	private void getString() {
	
		ChatModell.messages.clear();
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				
				ChatModell.messages.add(resultSet.getString("username") + " : " + resultSet.getString("message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
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
		conn = _conn;
		conn.connectToDatabase();
	}
}
