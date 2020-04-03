package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig 
{
	public void registerStompEndpoints (StompEndpointRegistry registry)
	{
		registry.addEndpoint("/ws").withSockJS();
	}
	
	public void configureMessageBroker (MessageBrokerRegistry registry)
	{
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");
	}
}
