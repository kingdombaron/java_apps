package com.spring.controller;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greetings {

	private List<Greeting> greetings;  
    
	protected Greetings() {}   // Keep JAXB happy  
	      
	public Greetings(List<Greeting> greetings)  
	{  
	    this.greetings = greetings;  
	}  
	     
	@XmlElement 
	public List<Greeting> getGreetings()   
	{  
	     return greetings;  
	}  
	
}
