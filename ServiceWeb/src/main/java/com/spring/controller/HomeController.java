package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/home2", method=RequestMethod.GET)
	public String getUserHtml() {
		logger.info("Entro en HOME!!!");
		
		return "prueba";
	}
		
}
