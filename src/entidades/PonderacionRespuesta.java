package entidades;

import jakarta.persistence.*;

@Entity
public class PonderacionRespuesta {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idPonderacionRespuesta")
	private int idPonderacionRespuesta;
	@Column(nullable = false, unique = false)
	private int ponderacion;
	@OneToOne
	@JoinColumn(name="respuesta_id", nullable = false, referencedColumnName="idRespuesta", 
				foreignKey=@ForeignKey(name="FK_Ponderacion_RTA", value=ConstraintMode.CONSTRAINT))
	private Respuesta respuesta;
	
	public PonderacionRespuesta() {
		super();
	}
	
	public PonderacionRespuesta(int ponderacion, Respuesta respuesta) {
		super();
		this.ponderacion = ponderacion;
		this.respuesta = respuesta;
	}
	
	public int getIdPonderacionRespuesta() {
		return idPonderacionRespuesta;
	}

	public int getPonderacion() {
		return ponderacion;
	}
	public void setPonderacion(int ponderacion) {
		this.ponderacion = ponderacion;
	}
	public Respuesta getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}
	
}
