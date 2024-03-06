package com.diluna.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	

	@RequestMapping("/test")
	public String SayHello() {
		return "home";
	}
}
