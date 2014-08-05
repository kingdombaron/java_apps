package com.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.CategoriaDAO;
import com.spring.model.Categoria;
import com.spring.model.Categorias;


@RestController
public class CategoriaController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CategoriaDAO categoriaDao;
	
	@RequestMapping(value = "/categorias",produces={"application/xml", "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Categorias getCategorias() {
		
		List<Categoria> ListCategoria = categoriaDao.findAll();
		
		Categorias categorias = new Categorias(ListCategoria);
		logger.info("DEVOLVIENDO CATEGORIAS");
		return  categorias;
		
	}
	
	@RequestMapping(value="/categorias.htm", method=RequestMethod.GET)
	public String getUserHtml() {
		
		//Test HTML view
		return "example";
	
	}
	
}
