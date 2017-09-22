package com.simpleChat.Chat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simpleChat.Chat.modell.ChatModell;

@RestController
public class ChatController {
	
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public String newMessage(@RequestParam("message") String message) {
		ChatModell.message=message;
		new DatabaseController().sendMessage(ChatModell.username, ChatModell.message, new Connect());
		return getChat();
	}
	
	private String getChat() {
	new	DatabaseController().getMessages(new Connect());
		String cache="";
		for(String act : ChatModell.messages) {
			cache+=act+" ";
		}
		return cache;
	}
	
}
