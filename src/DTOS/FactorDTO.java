package DTOS;

import java.util.List;

import entidades.Pregunta;

public class FactorDTO {

	
	
	private int idFactor;
	private String nombreFactor;
	private int codigo;
	private String descripcion;
	private int nroOrden;
	private List<PreguntaDTO> preguntas;
	
	
	
	public FactorDTO() {
		super();
	}



	public FactorDTO(String nombreFactor, int codigo, String descripcion, int nroOrden, List<PreguntaDTO> preguntas) {
		super();
		this.nombreFactor = nombreFactor;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nroOrden = nroOrden;
		this.preguntas = preguntas;
	}



	public int getIdFactor() {
		return idFactor;
	}



	public void setIdFactor(int idFactor) {
		this.idFactor = idFactor;
	}



	public String getNombreFactor() {
		return nombreFactor;
	}



	public void setNombreFactor(String nombreFactor) {
		this.nombreFactor = nombreFactor;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getNroOrden() {
		return nroOrden;
	}



	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}



	public List<PreguntaDTO> getPreguntas() {
		return preguntas;
	}



	public void setPreguntas(List<PreguntaDTO> preguntas) {
		this.preguntas = preguntas;
	}
	
	
	
	
	
}
