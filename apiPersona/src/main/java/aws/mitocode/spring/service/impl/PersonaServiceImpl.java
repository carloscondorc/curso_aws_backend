package aws.mitocode.spring.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import aws.mitocode.spring.dao.IPersonaDao;
import aws.mitocode.spring.model.Persona;
import aws.mitocode.spring.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;

	@Override
	public List<Persona> obtenerPersonas() {

		return this.personaDao.findAll();

	}
	
	@Override
	public Persona obtenerPersonaPorID(int id) {
		Persona curso = personaDao.findOne(id);
		//sede.getTiposServicios().size();
		
		return curso;
	}

	@Override
	public Page<Persona> obtenerDatosPaginados(Pageable pageable) {
		return this.personaDao.findAll(pageable);
	}

	@Override
	public void guardarDatos(Persona curso) {
		this.personaDao.save(curso);
		
	}

	@Override
	public void eliminarDatos(int id) {
		this.personaDao.delete(id);		
	}

}
