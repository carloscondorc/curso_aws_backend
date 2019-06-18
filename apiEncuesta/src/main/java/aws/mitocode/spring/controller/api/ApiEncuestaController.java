package aws.mitocode.spring.controller.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aws.mitocode.spring.dto.RespuestaApi;
import aws.mitocode.spring.model.Encuesta;
import aws.mitocode.spring.model.Curso;
import aws.mitocode.spring.service.IEncuestaService;
import aws.mitocode.spring.service.ICursoService;

@RestController
@CrossOrigin
@RequestMapping("api/encuesta")
public class ApiEncuestaController {

	private static final Logger logger = LoggerFactory.getLogger(ApiEncuestaController.class);
	
	@Autowired
	private IEncuestaService encuestaService;
	
	@Autowired
	private ICursoService cursoService;
	
	@GetMapping(value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obtenerTodos(Pageable pageable){
		try {
			User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return new ResponseEntity<Page<Encuesta>>(
					encuestaService.obtenerDatosPaginados(pageable, usuario.getUsername(), usuario.getAuthorities()), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping(value="registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaApi> guardarFeedBack(
			@RequestBody Encuesta curso){
		try {
			User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			//feedback.setIdUsuario(usuario.getUsername());
			encuestaService.guardarDatos(curso);
			return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",""), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaApi> eliminarFeedBack(
			@PathVariable int id){
		try {
			encuestaService.eliminarDatos(id);
			return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",""), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="curso/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> obtenerTodos(){
		try {
			return new ResponseEntity<List<Curso>>(cursoService.obtenerTodos(), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
