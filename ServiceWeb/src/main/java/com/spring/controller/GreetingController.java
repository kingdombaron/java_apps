package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET,produces={"application/xml", "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public Greetings getGreeting(@PathVariable String name) {
		
		List<Greeting> ListGreetings = new ArrayList<Greeting>();
		
		ListGreetings.add(new Greeting(counter.incrementAndGet(),
	            String.format(template, name)));
		
		ListGreetings.add(new Greeting(counter.incrementAndGet(),
	            String.format(template, name)));
		
		Greetings greetings = new Greetings(ListGreetings);
		return greetings;
		
	}
	
	@RequestMapping(value="/{name}.htm", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getUserHtml() {
		
		//Test HTML view
		return "example";
	
	}

}
