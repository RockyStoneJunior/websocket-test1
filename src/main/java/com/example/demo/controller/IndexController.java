package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/helloindex")
	public void index()
	{
		System.out.println("Hello Index");
	}
}
