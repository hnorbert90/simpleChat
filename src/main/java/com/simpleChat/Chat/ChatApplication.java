package com.simpleChat.Chat;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ChatApplication.class, args);
		//new DatabaseController().getMessages(new Connect());
		//new DatabaseController().sendMessage("jani", "hello", new Connect());
	}
}
