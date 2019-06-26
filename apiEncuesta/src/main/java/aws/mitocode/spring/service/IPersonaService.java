package aws.mitocode.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import aws.mitocode.spring.model.Persona;

public interface IPersonaService {
	void guardarDatos(Persona persona);

}
