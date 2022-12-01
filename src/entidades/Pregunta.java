package entidades;

import java.util.List;

public class Pregunta {
	private int idPregunta;
	private Factor factor;
	private String nombre;
	private String textoPregunta;
	private String descripcion;
	private OpcionDeRespuesta opcionDeRespuesta;
	private List<PonderacionRespuesta> respuestas;
	
	public Pregunta(Factor factor, String nombre, String textoPregunta, String descripcion,
			OpcionDeRespuesta opcionDeRespuesta, List<PonderacionRespuesta> respuestas) {
		super();
		this.factor = factor;
		this.nombre = nombre;
		this.textoPregunta = textoPregunta;
		this.descripcion = descripcion;
		this.opcionDeRespuesta = opcionDeRespuesta;
		this.respuestas = respuestas;
	}
	
	public int getIdPregunta() {
		return idPregunta;
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
