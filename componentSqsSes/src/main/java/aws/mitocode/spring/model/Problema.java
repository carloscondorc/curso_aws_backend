package aws.mitocode.spring.model;

import java.io.Serializable;

public class Problema implements Serializable {

	private static final long serialVersionUID = -3087067965523143057L;

	private int id;
	
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
