package aws.mitocode.spring.service.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import aws.mitocode.spring.dao.IEncuestaDao;
import aws.mitocode.spring.dao.IPersonaDao;
import aws.mitocode.spring.model.Encuesta;
import aws.mitocode.spring.model.Persona;
import aws.mitocode.spring.service.IEncuestaService;
@Service
public class EncuestaServiceImpl implements IEncuestaService {
	
	private Logger logger = Logger.getLogger(EncuestaServiceImpl.class);

	@Autowired
	private IEncuestaDao encuestaDao;
	
	@Autowired
	private IPersonaDao personaDao;
	
	
	@Override
	public Page<Encuesta> obtenerDatosPaginados(Pageable pageable, String usuario, Collection<GrantedAuthority> ltaRoles) {
		boolean isAdmin = false;
		if(ltaRoles != null && ltaRoles.size() > 0) {
			for(GrantedAuthority rol : ltaRoles) {
				if("ROLE_ADMIN".equalsIgnoreCase(rol.getAuthority())) {
					isAdmin = true;
					break;
				}
			}
		}
		if(isAdmin) {
			return encuestaDao.obtenerEncuestas(pageable);
		}
		return null;
		//return encuestaDao.obtenerFeedBacksPorUsuario(pageable, usuario);
	}

	@Override
	public void guardarDatos(Encuesta encuesta) {
		     Persona persona = new Persona();
		    //Encuesta encuestain = new Encuesta();
		    		 
		try {
			

			persona.setNombres(encuesta.getPersona().getNombres());
			persona.setApellidos(encuesta.getPersona().getApellidos());
			persona.setEdad(encuesta.getPersona().getEdad());
			persona.setProfesion(encuesta.getPersona().getProfesion());
			persona.setLugar_trabajo(encuesta.getPersona().getLugar_trabajo());
			persona=personaDao.save(persona);
			
			encuesta.getPersona().setId(persona.getId());
			encuestaDao.save(encuesta);
		
		
		}catch(Exception e) {
			logger.info("Error al guardar encuestas datos a rn BD");
		}
	}

	@Override
	public void eliminarDatos(int id) {
		encuestaDao.delete(id);
		
	}

}
