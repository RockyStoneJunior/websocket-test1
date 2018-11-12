package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.hello.Greeting;
import com.example.demo.hello.HelloMessage;

@Controller
public class GreetingController {
	
	@Autowired
	private SimpMessagingTemplate websocket;
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception{
		
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + ", this is my first websocket app!");
	}
	
	@Scheduled(cron = "*/3 * * * * *")
	public void websocketSend() throws Exception{
		
		System.out.println("auto sned");
		websocket.convertAndSend("/topic/greetings", "{\"content\":\"auto send!\"}");
	}
}
