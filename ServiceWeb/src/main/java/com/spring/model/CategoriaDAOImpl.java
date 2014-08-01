package com.spring.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CategoriaDAO;
import com.spring.repositories.CategoriaRepository;

@Service
public class CategoriaDAOImpl implements CategoriaDAO{

	/*private SessionFactory sessionFactory;
	 
    public CategoriaDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    @Override
    @Transactional
    public List<Categoria> list() {
        @SuppressWarnings("unchecked")
        List<Categoria> listCategoria = (List<Categoria>) sessionFactory.getCurrentSession()
                .createCriteria(Categoria.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listCategoria;
    }*/
	
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
