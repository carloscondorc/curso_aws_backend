package aws.mitocode.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aws.mitocode.spring.dao.ICursoDao;
import aws.mitocode.spring.model.Curso;
import aws.mitocode.spring.service.ICursoService;

@Service
public class ProblemaServiceImpl implements ICursoService {

	@Autowired
	private ICursoDao cursoDao;
	
	@Override
	public List<Curso> obtenerTodos() {
		return this.cursoDao.findAll();
	}

}
