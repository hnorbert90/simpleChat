package com.simpleChat.Chat;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.simpleChat.Chat.controllers.Connect;
import com.simpleChat.Chat.controllers.DatabaseController;
import com.simpleChat.Chat.modell.ChatModell;

@EnableConfigurationProperties
@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ChatApplication.class, args);
		
		//new DatabaseController().sendMessage("jani2", "hello2", new Connect());
		//new DatabaseController().getMessages(new Connect());
		//for(String act : ChatModell.messages) {
			//System.out.println(act);
		//}
		
	}
}
