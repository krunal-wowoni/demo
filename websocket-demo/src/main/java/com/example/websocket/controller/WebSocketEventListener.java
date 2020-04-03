package com.example.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.websocket.model.ChatMessage;

@Component
public class WebSocketEventListener 
{
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@EventListener
	public void handleWebSocketConnectListner(SessionConnectEvent event)
	{
		logger.info("Received a new web socket connection");
	}
	
	@EventListener
	public void handleWebSocketDisconnectListner(SessionDisconnectEvent event)
	{
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		if(username != null)
		{
			logger.info("User Disconnectd : "+ username);
			
			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setType(ChatMessage.MessageType.LEAVE);
			chatMessage.setSender(username);
			
			messagingTemplate.convertAndSend("/topic/public", chatMessage);
		}
	}
}
