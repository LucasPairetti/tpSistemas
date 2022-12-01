package entidades;

import java.util.List;

public class OpcionDeRespuesta {
	private int idOpcionDeRespuesta;
	private String nombre;
	private String descripcion;
	private List<Respuesta> listaRespuestas;
	
	public OpcionDeRespuesta(String nombre, String descripcion, List<Respuesta> listaRespuestas) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaRespuestas = listaRespuestas;
	}

	public int getIdOpcionDeRespuesta() {
		return idOpcionDeRespuesta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Respuesta> getListaRespuestas() {
		return listaRespuestas;
	}

	public void setListaRespuestas(List<Respuesta> listaRespuestas) {
		this.listaRespuestas = listaRespuestas;
	}
	
}
