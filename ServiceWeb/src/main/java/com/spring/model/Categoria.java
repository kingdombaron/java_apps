package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String titulo;
	private long categoria_padre;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public long getCategoria_padre() {
		return categoria_padre;
	}
	public void setCategoria_padre(long categoria_padre) {
		this.categoria_padre = categoria_padre;
	}
	
	
	
}
