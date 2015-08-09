package com.funkygames.funkyhilo.services;

public interface MessageService {
public static final String FIRST_CARD_MESSAGE_ID = "1crd";
	
	public static final String SECOND_CARD_MESSAGE_ID = "2crd";
	
	public static final String GAME_RESULT_MESSAGE_ID = "result";
	
	public void sendMessage(String messageId,String message);
	
	public String readMessage(String messageId);
}
