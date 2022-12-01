package entidades;

import java.util.Date;
import java.util.List; //o java.sql?
import jakarta.persistence.*;

@Entity
public class Candidato {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idCandidato")
	private int idCandidato;
	@Column(nullable = false, unique = true)
	private int numeroDocumento;
	@Column(nullable = false, unique = true)
	private String clave;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Cuestionario cuestionario;
	@Column(nullable = false, unique = false)
	private String tipoDocumento;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="candidato_id", nullable = false, referencedColumnName="idCandidato" , 
				foreignKey=@ForeignKey(name="FK_Candidato_Cuestionario", 
				value=ConstraintMode.CONSTRAINT))
	private List<Cuestionario> cuestionariosTerminados;
	@Column(nullable = false, unique = true)
	private int nroCandidato;
	@Column(nullable = false, unique = false)
	private String nombre;
	@Column(nullable = false, unique = false)
	private String apellido;
	@Column(nullable = false, unique = false)
	private Date fechaNacimiento;
	@Column(nullable = false, unique = false)
	private String nacionalidad;
	@Column(nullable = false, unique = false)
	private String email;
	@Column(nullable = false, unique = true)
	private String escolaridad;
	@Column
	private Boolean eliminacion;
	
	
	//NOTA: Este constructor se utiliza para fines practicos de la implementacion. Por consigna,
	//los candidatos deben ser importados de un archivo externo.
	
	public Candidato() {
		super();
	}
	
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
