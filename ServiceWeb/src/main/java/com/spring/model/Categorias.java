package com.spring.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Categorias {

	private List<Categoria> categorias;  
    
	protected Categorias() {}   // Keep JAXB happy  
	      
	public Categorias(List<Categoria> categorias)  
	{  
	    this.categorias = categorias;  
	}  
	     
	@XmlElement 
	public List<Categoria> getCategorias()   
	{  
	     return categorias;  
	} 
	
}
