package com.funkygames.funkyhilo.services;

public interface MessageService {
	public void sendMessage(String messageId,String message);
	
	public String readMessage(String messageId);
}
