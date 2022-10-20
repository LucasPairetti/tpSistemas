package entidades;

import java.util.List;
import java.util.Objects;

public class Puesto  {
	private int idPuesto;
	private int codigo;
	private String nombrePuesto;
	private String empresa;
	private List<ItemCompetencia> competencias;
	
	
	public Puesto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Puesto(int idPuesto, int codigo, String nombrePuesto, String empresa, List<ItemCompetencia> competencias) {
		super();
		this.idPuesto = idPuesto;
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
