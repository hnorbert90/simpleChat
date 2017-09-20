package com.simpleChat.Chat.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatService {

	@RequestMapping("/")
	public String openChat() {
		String html = "";

		return html;

	}

}
