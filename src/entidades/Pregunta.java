package entidades;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Pregunta {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idPregunta")
	private int idPregunta;
	/*@ManyToOne
	@JoinColumn(name="factor_id", nullable = false, referencedColumnName="idFactor", 
				foreignKey=@ForeignKey(name="FK_Factor_Pregunta", value=ConstraintMode.CONSTRAINT))
	private Factor factor;*/
	@Column(nullable = false, unique = true)
	private String nombre;
	@Column(nullable = false, unique = true)
	private String textoPregunta;
	@Column(nullable = false)
	private String descripcion;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="opcionDeRta_id", nullable = false, referencedColumnName="idOpcionDeRespuesta", 
				foreignKey=@ForeignKey(name="FK_Pregunta_Opcion", value=ConstraintMode.CONSTRAINT))
	private OpcionDeRespuesta opcionDeRespuesta;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="pregunta_id", nullable = false, referencedColumnName="idPregunta", 
	foreignKey=@ForeignKey(name="FK_Pregunta_Ponderacion", value=ConstraintMode.CONSTRAINT))
	private List<PonderacionRespuesta> respuestas;
	
	public Pregunta() {
		super();
	}
	
	public Pregunta(Factor factor, String nombre, String textoPregunta, String descripcion,
			OpcionDeRespuesta opcionDeRespuesta, List<PonderacionRespuesta> respuestas) {
		super();
		//this.factor = factor;
		this.nombre = nombre;
		this.textoPregunta = textoPregunta;
		this.descripcion = descripcion;
		this.opcionDeRespuesta = opcionDeRespuesta;
		this.respuestas = respuestas;
	}
	
	public int getIdPregunta() {
		return idPregunta;
	}

	//public Factor getFactor() {
	//	return factor;
	//}
	//public void setFactor(Factor factor) {
	//	this.factor = factor;
	//}
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
	public OpcionDeRespuesta getOpcionDeRespuesta() {
		return opcionDeRespuesta;
	}
	public void setOpcionDeRespuesta(OpcionDeRespuesta opcionDeRespuesta) {
		this.opcionDeRespuesta = opcionDeRespuesta;
	}
	public List<PonderacionRespuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<PonderacionRespuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
}
