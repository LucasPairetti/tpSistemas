package entidades;

import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Puesto  {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idPuesto;
	@Column(nullable = false, unique = true)
	private int codigo;
	@Column(nullable = false, unique = true)
	private String nombrePuesto;
	@Column(nullable = false)
	private String empresa;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemCompetencia> competencias;
	@Column(nullable = true)
	private int idAuditoria;
	
	public Puesto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Puesto(int codigo, String nombrePuesto, String empresa, List<ItemCompetencia> competencias) {
		super();
		this.codigo = codigo;
		this.nombrePuesto = nombrePuesto;
		this.empresa = empresa;
		this.competencias = competencias;
	}
	public int getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(int idPuesto) {
		this.idPuesto = idPuesto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombrePuesto() {
		return nombrePuesto;
	}
	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public List<ItemCompetencia> getCompetencias() {
		return competencias;
	}
	public void setCompetencias(List<ItemCompetencia> competencias) {
		this.competencias = competencias;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo, competencias, empresa, idPuesto, nombrePuesto);
	}
	
	public void addItemCompetencia(ItemCompetencia item) {
		this.competencias.add(item);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puesto other = (Puesto) obj;
		return codigo == other.codigo && Objects.equals(competencias, other.competencias)
				&& Objects.equals(empresa, other.empresa) && idPuesto == other.idPuesto
				&& Objects.equals(nombrePuesto, other.nombrePuesto);
	}
	
	
	
	
}
