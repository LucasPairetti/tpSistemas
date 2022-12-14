package entidades;

import jakarta.persistence.*;

@Entity
public class PonderacionRtaCuestionario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idPonderacionRtaCuestionario")
	private int idPonderacionRtaCuestionario;
	@Column(nullable = false)
	private int ponderacion;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="respuesta_id", nullable = false, referencedColumnName="idRespuestaEnCuestionario", 
				foreignKey=@ForeignKey(name="FK_Ponderacion_RespuestaEnCuestionario", 
				value=ConstraintMode.CONSTRAINT))
	private RespuestaEnCuestionario respuesta;
	
	public PonderacionRtaCuestionario() {
		super();
	}
	
	public PonderacionRtaCuestionario(PonderacionRespuesta ponderacion) {
		super();
		this.ponderacion = ponderacion.getPonderacion();
		this.respuesta = new RespuestaEnCuestionario(ponderacion.getRespuesta());
	}

	public int getIdPonderacionRtaCuestionario() {
		return idPonderacionRtaCuestionario;
	}

	public int getPonderacion() {
		return ponderacion;
	}
	public void setPonderacion(int ponderacion) {
		this.ponderacion = ponderacion;
	}
	public RespuestaEnCuestionario getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(RespuestaEnCuestionario respuesta) {
		this.respuesta = respuesta;
	}

	
	
}
