package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.model.Categoria;

@Component
public interface CategoriaDAO{

	public List<Categoria> findAll();
	
}
