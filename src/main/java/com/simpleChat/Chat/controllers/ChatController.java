package com.simpleChat.Chat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.Messages;
import com.simpleChat.Chat.modell.ChatModell;

@RestController
public class ChatController {
	
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public String  newMessage(@RequestParam("message") String message) {
		if(message!="") {
			ChatModell.message=message;
		
		new DatabaseController().sendMessage(ChatModell.date, ChatModell.message, new Connect());
		}
		return getChat()+"<br> <a href=\"/index.html\">Back</a>";
	}
	
	private String getChat() {
	new	DatabaseController().getMessages(new Connect());
	if(ChatModell.messages.size()==0) return "Nincs bejegyzés";
		
		String cache="";
		for(String act : ChatModell.messages) {
			
			
			cache+=act+" <br>";
		}
		return cache;
	}
	
	@RequestMapping(value="/messages",method=RequestMethod.GET)
	public String  read() {
		return getChat()+"<br> <a href=\"/index.html\">Back</a>";
	}
	
}
