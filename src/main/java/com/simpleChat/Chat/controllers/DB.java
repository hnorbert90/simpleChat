package com.simpleChat.Chat.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties("mysql")
public class DB {

	private static String url;
	private static String username;
	private static String password;
	private static String database;

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public static String getDatabase() {
		return database;
	}

	public static String getTable() {
		return table;
	}

	private static String table;

	protected static Statement statement = null;
	protected static ResultSet resultSet = null;
	protected static Connection connect = null;
	protected static PreparedStatement preparedStatement = null;

	public static void setUrl(String url) {
		DB.url = url;
	}

	public static void setUsername(String username) {
		DB.username = username;
	}

	public static void setPassword(String password) {
		DB.password = password;
	}

	public static void setDatabase(String database) {
		DB.database = database;
	}

	public static void setTable(String table) {
		DB.table = table;
	}

}
