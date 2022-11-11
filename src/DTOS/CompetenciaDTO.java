package DTOS;

import java.util.Objects;

import entidades.Competencia;

public class CompetenciaDTO extends Competencia{

	private int idCompetencia;
	
	private int codigo;
	
	private String nombreCompetencia;
	
	private String descripcion;
	
	
	public CompetenciaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CompetenciaDTO(int codigo, String nombreCompetencia, String descripcion) {
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



	@Override
	public int hashCode() {
		return Objects.hash(codigo, descripcion, idCompetencia, nombreCompetencia);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetenciaDTO other = (CompetenciaDTO) obj;
		return codigo == other.codigo && Objects.equals(descripcion, other.descripcion)
				&& idCompetencia == other.idCompetencia && Objects.equals(nombreCompetencia, other.nombreCompetencia);
	}
	
	
}
