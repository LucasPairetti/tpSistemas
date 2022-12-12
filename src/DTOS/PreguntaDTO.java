package DTOS;

import java.util.List;

import entidades.OpcionDeRespuesta;
import entidades.PonderacionRespuesta;
import entidades.Pregunta;

public class PreguntaDTO{

	private int idPregunta;
	private String nombre;
	private String textoPregunta;
	private String descripcion;
	//private OpcionDeRespuesta opcionDeRespuesta;
	private List<PonderacionRespuestaDTO> respuestas;
	
	
	public PreguntaDTO() {
		super();
	}


	public PreguntaDTO(String nombre, String textoPregunta, String descripcion,
			List<PonderacionRespuestaDTO> respuestas) {
		super();
		this.nombre = nombre;
		this.textoPregunta = textoPregunta;
		this.descripcion = descripcion;
		//this.opcionDeRespuesta = opcionDeRespuesta;
		this.respuestas = respuestas;
	}


	public int getIdPregunta() {
		return idPregunta;
	}


	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
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


	/*public OpcionDeRespuesta getOpcionDeRespuesta() {
		return opcionDeRespuesta;
	}


	public void setOpcionDeRespuesta(OpcionDeRespuesta opcionDeRespuesta) {
		this.opcionDeRespuesta = opcionDeRespuesta;
	}
*/

	public List<PonderacionRespuestaDTO> getRespuestas() {
		return respuestas;
	}


	public void setRespuestas(List<PonderacionRespuestaDTO> respuestas) {
		this.respuestas = respuestas;
	}
	
	
	
	
}
