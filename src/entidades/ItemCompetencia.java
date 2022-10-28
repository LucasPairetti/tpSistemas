package entidades;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;


@Entity
public class ItemCompetencia {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idItemCompetencia;
	@ManyToOne
	private Puesto puesto;
	@OneToOne
	private Competencia competencia;
	@Column(nullable = false)
	private int ponderacion;
	
	
	public ItemCompetencia(Puesto idPuesto, Competencia competencia, int ponderacion) {
		super();
		this.puesto = idPuesto;
		this.competencia = competencia;
		this.ponderacion = ponderacion;
	}


	public Puesto getPuesto() {
		return puesto;
	}


	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
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
