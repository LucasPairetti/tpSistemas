package entidades;

import jakarta.persistence.*;

@Entity
public class ItemCompetencia {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idItemCompetencia;
	@ManyToOne(cascade = CascadeType.ALL)
	private Puesto idPuesto;
	@OneToOne(cascade = CascadeType.ALL)
	private Competencia competencia;
	@Column(nullable = false)
	private int ponderacion;
	
	
	public ItemCompetencia(Puesto puesto, Competencia competencia, int ponderacion) {
		super();
		this.idPuesto = puesto;
		this.competencia = competencia;
		this.ponderacion = ponderacion;
	}
	public ItemCompetencia(Competencia competencia, int ponderacion) {
		super();
		this.competencia = competencia;
		this.ponderacion = ponderacion;
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public int getPonderacion() {
		return ponderacion;
	}
	public void setPonderacion(int ponderacion) {
		this.ponderacion = ponderacion;
	}
	
}
