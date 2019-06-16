package aws.mitocode.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import aws.mitocode.spring.model.Curso;

public interface ICursoService {

	List<Curso> obtenerCursos();
	Curso obtenerCursoPorID(int id);
	Page<Curso> obtenerDatosPaginados(Pageable pageable);
	void guardarDatos(Curso curso);
	void eliminarDatos(int id);
}
