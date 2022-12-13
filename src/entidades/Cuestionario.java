package entidades;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.*;

@Entity
public class Cuestionario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idCuestionario")
	private int idCuestionario;
	@ManyToOne
	@JoinColumn(name="candidato_id", nullable = false, referencedColumnName="idCandidato" , 
	foreignKey=@ForeignKey(name="FK_Candidato_Cuestionario", 
	value=ConstraintMode.CONSTRAINT))
	private Candidato candidato;
	//private int nroDocumento;
	private String clave;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="idCuestionario", nullable = false, referencedColumnName="idCuestionario" , 
	foreignKey=@ForeignKey(name="FK_Cuestionario_Estado", value=ConstraintMode.CONSTRAINT))
	private Estado estado;
	@Column(nullable = false)
	private int cantidadAccesos;
	@Column(nullable = true)
	private Date fechaComienzo;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="cuestionario_id", nullable = false, referencedColumnName="idCuestionario" , 
				foreignKey=@ForeignKey(name="FK_Bloque_Cuestionario", value=ConstraintMode.CONSTRAINT))
	private List<Bloque> bloques;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="cuestionario_id", nullable = false, referencedColumnName="idCuestionario" , 
	foreignKey=@ForeignKey(name="FK_PuntajePorCompetencia_Cuestionario", value=ConstraintMode.CONSTRAINT))
	private List<PuntajePorCompetencia> resultadoXCompetencia;
	@Column(nullable = true)
	private int resultadoFinal;
	@Column(nullable = true)
	private Date fechaFinal;
	@Column(nullable = true)
	private Date ultimoAcceso;
	//Agregamos un historial de cuestionario?
	
	public Cuestionario() {
		super();
	}
	
	public Cuestionario(Candidato candidato, String clave, Estado estado, int cantidadAccesos,
			Date fechaComienzo, List<Bloque> bloques, List<PuntajePorCompetencia> resultadoXCompetencia,
			int resultadoFinal, Date fechaFinal, Date ultimoAcceso) {
		super();
		this.candidato = candidato;
		this.clave = clave;
		this.estado = estado;
		this.cantidadAccesos = cantidadAccesos;
		this.fechaComienzo = fechaComienzo;
		this.bloques = bloques;
		this.resultadoXCompetencia = resultadoXCompetencia;
		this.resultadoFinal = resultadoFinal;
		this.fechaFinal = fechaFinal;
		this.ultimoAcceso = ultimoAcceso;
	}
	
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
	public Bloque getBloqueByNro(int numero) {
		for(Bloque b : this.bloques) {
			if(numero == b.getNumeroBloque()) return b;
		}
		return null;
	}
}
