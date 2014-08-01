package com.spring.controller;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting extends Greeter implements Serializable{

    private long id;
    private String content;

    public Greeting(){
    	
    }
    
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @XmlAttribute
    public long getId() {
        return id;
    }
    
    @XmlAttribute
    public String getContent() {
        return content;
    }
    
    public String sayHello() {
        return "Hello world!";
    }
}
