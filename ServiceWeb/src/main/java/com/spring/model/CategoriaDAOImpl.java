package com.spring.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CategoriaDAO;
import com.spring.repositories.CategoriaRepository;

@Service
public class CategoriaDAOImpl implements CategoriaDAO{
	
	@Resource
	private CategoriaRepository categoriaRepository;
 
    public CategoriaDAOImpl() {
       
    }
	
    @Override
    @Transactional
    public List<Categoria> findAll() {
      return (List<Categoria>) categoriaRepository.findAll();
    }
	

}
