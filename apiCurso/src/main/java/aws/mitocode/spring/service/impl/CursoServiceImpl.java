package aws.mitocode.spring.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import aws.mitocode.spring.dao.ICursoDao;
import aws.mitocode.spring.model.Curso;
import aws.mitocode.spring.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private ICursoDao cursoDao;

	@Override
	public List<Curso> obtenerCursos() {

		return this.cursoDao.findAll();

	}
	
	@Override
	public Curso obtenerCursoPorID(int id) {
		Curso curso = cursoDao.findOne(id);
		//sede.getTiposServicios().size();
		
		return curso;
	}

	@Override
	public Page<Curso> obtenerDatosPaginados(Pageable pageable) {
		return this.cursoDao.findAll(pageable);
	}

	@Override
	public void guardarDatos(Curso curso) {
		this.cursoDao.save(curso);
		
	}

	@Override
	public void eliminarDatos(int id) {
		this.cursoDao.delete(id);		
	}

}
