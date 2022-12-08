package entidades;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Competencia {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idCompetencia")
	private int idCompetencia;
	@Column(nullable = false, unique=true)
	private int codigo;
	@Column(unique=true, nullable = false)
	private String nombreCompetencia;
	@Column(nullable = false)
	private String descripcion;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="competencia_id", nullable = true, referencedColumnName="idCompetencia" , 
	foreignKey=@ForeignKey(name="FK_Factor_Comp", value=ConstraintMode.CONSTRAINT))
	private List<Factor> factores;

	public Competencia(int codigo, String nombreCompetencia, String descripcion,
			List<Factor> factores) {
		super();
		this.codigo = codigo;
		this.nombreCompetencia = nombreCompetencia;
		this.descripcion = descripcion;
		this.factores = factores;
	}

	public Competencia() {
		super();
		
	}


	public List<Factor> getFactores() {
		return factores;
	}

	public void setFactores(List<Factor> factores) {
		this.factores = factores;
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
		Competencia other = (Competencia) obj;
		return codigo == other.codigo && Objects.equals(descripcion, other.descripcion)
				&& idCompetencia == other.idCompetencia && Objects.equals(nombreCompetencia, other.nombreCompetencia);
	}
	
	
	
	
	
	
}
