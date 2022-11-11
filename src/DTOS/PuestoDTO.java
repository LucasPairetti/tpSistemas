package DTOS;

import java.util.List;
import java.util.Objects;

import entidades.ItemCompetencia;
import entidades.Puesto;


public class PuestoDTO extends Puesto {
	
	private int idPuesto;
	private int codigo;
	private String nombrePuesto;
	private String empresa;
	private String descripcion;
	private List<ItemCompetencia> competencias;
	private int idAuditoria = -1;
	//auditoria
	
	public PuestoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PuestoDTO(int codigo, String nombrePuesto, String empresa, String descripcion, List<ItemCompetencia> competencias) {
		super();
		this.codigo = codigo;
		this.nombrePuesto = nombrePuesto;
		this.empresa = empresa;
		this.descripcion=descripcion;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PuestoDTO other = (PuestoDTO) obj;
		return codigo == other.codigo && Objects.equals(competencias, other.competencias)
				&& Objects.equals(empresa, other.empresa) && idPuesto == other.idPuesto
				&& Objects.equals(nombrePuesto, other.nombrePuesto);
	}
	public void addItemCompetencia(ItemCompetencia itemCompetencia) {
		// TODO Auto-generated method stub
		this.competencias.add(itemCompetencia);
	}


}
