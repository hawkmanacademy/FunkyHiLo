package com.funkygames.funkyhilo.services;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMessageService implements MessageService {

	private Map<String,String> messageBus = new HashMap<String, String>();
	@Override
	public void sendMessage(String messageId, String message) {
		messageBus.put(messageId, message);
	}

	@Override
	public String readMessage(String messageId) {
		return messageBus.get(messageId);
	}

}
