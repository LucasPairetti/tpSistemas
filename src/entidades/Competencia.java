package entidades;

import jakarta.persistence.*;

@Entity
public class Competencia {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCompetencia;
	@Column(nullable = false, unique=true)
	private int codigo;
	@Column(unique=true, nullable = false)
	private String nombreCompetencia;
	@Column(nullable = false)
	private String descripcion;
	
	
	
	public Competencia() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Competencia(int codigo, String nombreCompetencia, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombreCompetencia = nombreCompetencia;
		this.descripcion = descripcion;
	}



	public int getIdCompetencia() {
		return idCompetencia;
	}



	public void setIdCompetencia(int idCompetencia) {
		this.idCompetencia = idCompetencia;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombreCompetencia() {
		return nombreCompetencia;
	}



	public void setNombreCompetencia(String nombreCompetencia) {
		this.nombreCompetencia = nombreCompetencia;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
}
