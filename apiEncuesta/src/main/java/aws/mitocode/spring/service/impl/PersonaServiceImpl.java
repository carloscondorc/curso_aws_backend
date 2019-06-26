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
	public void guardarDatos(Persona curso) {
		this.personaDao.save(curso);
		
	}


}
