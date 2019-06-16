package aws.mitocode.spring.service;

import java.util.List;

import aws.mitocode.spring.model.Curso;

public interface ICursoService {
	
	public List<Curso> obtenerTodos();
}
