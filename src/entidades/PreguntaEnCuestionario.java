package entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class PreguntaEnCuestionario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idPreguntaEnCuestionario")
	private int idPreguntaEnCuestionario;
	@ManyToOne
	@JoinColumn(name="factor_id", nullable = false, referencedColumnName="idFactor",
				foreignKey=@ForeignKey(name="FK_PreguntaEnCuestionario_Factor", value=ConstraintMode.CONSTRAINT))
	private Factor factor;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String textoPregunta;
	@Column(nullable = false)
	private String descripcion;
	@OneToMany
	@JoinColumn(name="preguntaEnCuestionario_id", nullable = false, referencedColumnName="idPreguntaEnCuestionario",
	foreignKey=@ForeignKey(name="FK_PreguntaEnCuestionario_ponderacion", value=ConstraintMode.CONSTRAINT))
	private List<PonderacionRtaCuestionario> respuestas;
	@OneToOne
	private RespuestaEnCuestionario rtaSeleccionada;
	
	public PreguntaEnCuestionario() {
		super();
	}
	
	public PreguntaEnCuestionario(Factor factor, Pregunta pregunta) {
		super();
		this.factor = factor;
		this.nombre = pregunta.getNombre();
		this.textoPregunta = pregunta.getTextoPregunta();
		this.descripcion = pregunta.getDescripcion();
		
		this.respuestas = new ArrayList<PonderacionRtaCuestionario>();
		
		for(PonderacionRespuesta p : pregunta.getRespuestas()) {
		this.respuestas.add( new PonderacionRtaCuestionario(p));
		}
		
		this.rtaSeleccionada = null;
	}

	public int getIdPreguntaEnCuestionario() {
		return idPreguntaEnCuestionario;
	}

	public Factor getFactor() {
		return factor;
	}
	public void setFactor(Factor factor) {
		this.factor = factor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTextoPregunta() {
		return textoPregunta;
	}
	public void setTextoPregunta(String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<PonderacionRtaCuestionario> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<PonderacionRtaCuestionario> respuestas) {
		this.respuestas = respuestas;
	}
	public RespuestaEnCuestionario getRtaSeleccionada() {
		return rtaSeleccionada;
	}
	public void setRtaSeleccionada(RespuestaEnCuestionario rtaSeleccionada) {
		this.rtaSeleccionada = rtaSeleccionada;
	}
	
	
}
