package entidades;

import jakarta.persistence.*;


@Entity
public class ItemCompetencia {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idItemCompetencia;
	@OneToOne
	@JoinColumn(name="competencia_id", nullable = false, referencedColumnName="idCompetencia", 
				foreignKey=@ForeignKey(name="FK_Item_Comp", value=ConstraintMode.CONSTRAINT))
	private Competencia competencia;
	@Column(nullable = false)
	private int ponderacion;
	
	public ItemCompetencia() { super();}
	
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
