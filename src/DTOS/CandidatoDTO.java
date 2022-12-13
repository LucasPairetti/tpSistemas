package DTOS;

import java.util.Date;
import java.util.List;

import entidades.Cuestionario;


////


public class CandidatoDTO {
	
	private int idCandidato;
	private int numeroDocumento;
	private String clave;
	private String tipoDocumento;
	private int nroCandidato;
	private String nombre;
	private String apellido;
	private String nacionalidad;
	private String email;
	private String escolaridad;
	private Boolean eliminacion;
	
	
	
	
	
	public CandidatoDTO() {
		super();
	}


	


	public CandidatoDTO(int numeroDocumento, String clave, Cuestionario cuestionario, String tipoDocumento,
			List<Cuestionario> cuestionariosTerminados, int nroCandidato, String nombre, String apellido,
			String nacionalidad, String email, String escolaridad, Boolean eliminacion) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.clave = clave;
		this.tipoDocumento = tipoDocumento;
		this.nroCandidato = nroCandidato;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.email = email;
		this.escolaridad = escolaridad;
		this.eliminacion = eliminacion;
	}





	public int getIdCandidato() {
		return idCandidato;
	}





	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}





	public int getNumeroDocumento() {
		return numeroDocumento;
	}





	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}





	public String getClave() {
		return clave;
	}





	public void setClave(String clave) {
		this.clave = clave;
	}




	public String getTipoDocumento() {
		return tipoDocumento;
	}





	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}




	public int getNroCandidato() {
		return nroCandidato;
	}





	public void setNroCandidato(int nroCandidato) {
		this.nroCandidato = nroCandidato;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getApellido() {
		return apellido;
	}





	public void setApellido(String apellido) {
		this.apellido = apellido;
	}





	public String getNacionalidad() {
		return nacionalidad;
	}





	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getEscolaridad() {
		return escolaridad;
	}





	public void setEscolaridad(String escolaridad) {
		this.escolaridad = escolaridad;
	}





	public Boolean getEliminacion() {
		return eliminacion;
	}





	public void setEliminacion(Boolean eliminacion) {
		this.eliminacion = eliminacion;
	}






	
	
	
	

}
