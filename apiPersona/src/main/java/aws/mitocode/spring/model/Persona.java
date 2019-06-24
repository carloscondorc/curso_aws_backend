package aws.mitocode.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = -1642431170636236810L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombres", nullable = false, length = 40)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false, length = 40)
	private String apellidos;
	
	@Column(name = "edad", nullable = false, length = 2)
	private int edad;
	

	@Column(name = "profesion", nullable = false, length = 40)
	private String profesion;
	

	@Column(name = "lugar_trabajo", nullable = false, length = 40)
	private String lugar_trabajo;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getProfesion() {
		return profesion;
	}


	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}


	public String getLugar_trabajo() {
		return lugar_trabajo;
	}


	public void setLugar_trabajo(String lugar_trabajo) {
		this.lugar_trabajo = lugar_trabajo;
	}
}
