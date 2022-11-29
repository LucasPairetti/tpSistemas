package entidades;

import java.util.Date;
import java.util.List; //o java.sql?

public class Candidato {
	private int idCandidato;
	private int numeroDocumento;
	private String clave;
	private Cuestionario cuestionario;
	private String tipoDocumento;
	private List<Cuestionario> cuestionariosTerminados;
	private int nroCandidato;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String email;
	private String escolaridad;
	private Boolean eliminacion;
	
	
	//NOTA: Este constructor se utiliza para fines practicos de la implementacion. Por consigna,
	//los candidatos deben ser importados de un archivo externo.
	
	public Candidato(int idCandidato, int numeroDocumento, String clave, Cuestionario cuestionario,
			String tipoDocumento, List<Cuestionario> cuestionariosTerminados, int nroCandidato, String nombre,
			String apellido, Date fechaNacimiento, String nacionalidad, String email, String escolaridad,
			Boolean eliminacion) {
		super();
		this.idCandidato = idCandidato;
		this.numeroDocumento = numeroDocumento;
		this.clave = clave;
		this.cuestionario = cuestionario;
		this.tipoDocumento = tipoDocumento;
		this.cuestionariosTerminados = cuestionariosTerminados;
		this.nroCandidato = nroCandidato;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
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
	public Cuestionario getCuestionario() {
		return cuestionario;
	}
	public void setCuestionario(Cuestionario cuestionario) {
		this.cuestionario = cuestionario;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public List<Cuestionario> getCuestionariosTerminados() {
		return cuestionariosTerminados;
	}
	public void setCuestionariosTerminados(List<Cuestionario> cuestionariosTerminados) {
		this.cuestionariosTerminados = cuestionariosTerminados;
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
