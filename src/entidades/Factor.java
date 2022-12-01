package entidades;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Factor {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idFactor")
	private int idFactor;
	@Column(nullable = false, unique = true)
	private String nombreFactor;
	@Column(nullable = false, unique = true)
	private int codigo;
	@Column(nullable = false)
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="competencia_id", nullable = false, referencedColumnName="idCompetencia" , 
	foreignKey=@ForeignKey(name="FK_Factor_Comp", value=ConstraintMode.CONSTRAINT))
	private Competencia competencia;
	@Column(nullable = false)
	private int nroOrden;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="factor_id", nullable = false, referencedColumnName="idFactor" , 
	foreignKey=@ForeignKey(name="FK_Factor_Pregunta", value=ConstraintMode.CONSTRAINT))
	private List<Pregunta> preguntas;
	
	public Factor() {
		super();
	}
	
	public Factor(String nombreFactor, int codigo, String descripcion, Competencia competencia,
			int nroOrden, List<Pregunta> preguntas) {
		super();
		this.nombreFactor = nombreFactor;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.competencia = competencia;
		this.nroOrden = nroOrden;
		this.preguntas = preguntas;
	}
	
	public int getIdFactor() {
		return idFactor;
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
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
}
