package entidades;

import jakarta.persistence.*;

@Entity
public class PuntajePorCompetencia {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idPuntajePorCompetencia")
	private int idPuntajePorCompetencia;
	@Column(nullable = false)
	private int puntaje;
	@OneToOne
	@JoinColumn(name="competencia_id", nullable = false, referencedColumnName="idCompetencia", 
	foreignKey=@ForeignKey(name="FK_Ponderacion_Comp", value=ConstraintMode.CONSTRAINT))
	private Competencia competencia;
	
	public PuntajePorCompetencia() {
		super();
	}
	
	public PuntajePorCompetencia(int puntaje, Competencia competencia) {
		super();
		this.puntaje = puntaje;
		this.competencia = competencia;
	}
	public int getIdPuntajePorCompetencia() {
		return idPuntajePorCompetencia;
	}

	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	
}
