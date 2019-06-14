package aws.mitocode.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aws.mitocode.spring.dao.ISedeDao;
import aws.mitocode.spring.model.Negocio;
import aws.mitocode.spring.model.Sede;
import aws.mitocode.spring.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService {

	@Autowired
	private ISedeDao sedeDao;

	@Value("${url.servicio.negocio}")
	private String urlApiNegocio;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Sede> obtenerSedesPorRadioLatitudLongitud(int tipoNegocio, double latitud, double longitud,
			double radio) {
		double latitudMenor = latitud - radio;
		double latitudMayor = latitud + radio;
		double longitudMenor = longitud - radio;
		double longitudMayor = longitud + radio;
		return sedeDao.obtenerSedesPorRadioCoordenadas(latitudMenor, latitudMayor, longitudMenor, longitudMayor, tipoNegocio);
	}

	@Override
	public List<Sede> obtenerSedesPorRadioLatitudLongitud2(int tipoNegocio, double latitud, double longitud,
			double radio, String headerAuthorization) {
		double latitudMenor = latitud - radio;
		double latitudMayor = latitud + radio;
		double longitudMenor = longitud - radio;
		double longitudMayor = longitud + radio;

		List<Sede> ltaFinalSedes = new ArrayList<Sede>();

		try {
			String URL = urlApiNegocio;
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
			headers.add("Authorization", headerAuthorization);

			System.out.println("headerAuthorization: " + headerAuthorization);
			System.out.println("URL: " + URL);

			ResponseEntity<List<Negocio>> response = restTemplate.exchange(URL + "/listar", 
				HttpMethod.GET, 
				new HttpEntity<Object>(headers), 
				new ParameterizedTypeReference<List<Negocio>>() {});
			
			System.out.println("HTTP STATUS RESPONSE: " + response.getStatusCode());

			Negocio negocioValido = null;
			for(Negocio negocio : response.getBody()){
				if(negocio.getId() == tipoNegocio){
					negocioValido = negocio;
					break;
				}
			}

			if(negocioValido == null){
				System.err.println("No se encontro un negocio valido");
				throw new Exception("Negocio Invalido");
			}

			System.out.println("Negocio valido encontrado: " + negocioValido.getNombre());

			List<Sede> ltaPreviaSedes = sedeDao.obtenerSedesPorRadioCoordenadas2(latitudMenor, latitudMayor, longitudMenor, longitudMayor);

			for(Sede sede : ltaPreviaSedes){
				if(sede.getNegocio().getId() == negocioValido.getId()){
					ltaFinalSedes.add(sede);
				}
			}


		}catch(Exception e) {
			e.printStackTrace();
		}

		return ltaFinalSedes;
	}
	
	@Override
	public Sede obtenerSedePorID(int id) {
		Sede sede = sedeDao.findOne(id);
		//sede.getTiposServicios().size();
		
		return sede;
	}

	@Override
	public Page<Sede> obtenerDatosPaginados(Pageable pageable) {
		return this.sedeDao.findAll(pageable);
	}

	@Override
	public void guardarDatos(Sede sede) {
		this.sedeDao.save(sede);
		
	}

	@Override
	public void eliminarDatos(int id) {
		this.sedeDao.delete(id);		
	}

}
