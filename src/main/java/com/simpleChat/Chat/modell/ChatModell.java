package com.simpleChat.Chat.modell;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatModell {

	public static ArrayList<String> messages=new ArrayList<String>();;
	public static String message;
	public static String date=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
	

	
}
