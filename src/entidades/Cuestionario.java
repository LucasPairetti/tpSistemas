package entidades;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Cuestionario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idCuestionario")
	private int idCuestionario;
	@ManyToOne
	private Candidato candidato;
	//private int nroDocumento;
	private String clave;
	@Column(nullable = true)
	private Estado estado;
	@Column(nullable = false)
	private int cantidadAccesos;
	@Column
	private Date fechaComienzo;
	@Column
	private List<Bloque> bloques;
	@Column
	private List<PuntajePorCompetencia> resultadoXCompetencia;
	@Column
	private int resultadoFinal;
	@Column
	private Date fechaFinal;
	@Column
	private Date ultimoAcceso;
	
	public int getIdCuestionario() {
		return idCuestionario;
	}
	public void setIdCuestionario(int idCuestionario) {
		this.idCuestionario = idCuestionario;
	}

	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getCantidadAccesos() {
		return cantidadAccesos;
	}
	public void setCantidadAccesos(int cantidadAccesos) {
		this.cantidadAccesos = cantidadAccesos;
	}
	public Date getFechaComienzo() {
		return fechaComienzo;
	}
	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}
	public List<Bloque> getBloques() {
		return bloques;
	}
	public void setBloques(List<Bloque> bloques) {
		this.bloques = bloques;
	}
	public List<PuntajePorCompetencia> getResultadoXCompetencia() {
		return resultadoXCompetencia;
	}
	public void setResultadoXCompetencia(List<PuntajePorCompetencia> resultadoXCompetencia) {
		this.resultadoXCompetencia = resultadoXCompetencia;
	}
	public int getResultadoFinal() {
		return resultadoFinal;
	}
	public void setResultadoFinal(int resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}
}
