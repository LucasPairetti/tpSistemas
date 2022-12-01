package entidades;

import java.util.List;

public class Factor {
	private int idFactor;
	private String nombreFactor;
	private int codigo;
	private String descripcion;
	private Competencia competencia;
	private int nroOrden;
	private List<Pregunta> preguntas;
	
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
