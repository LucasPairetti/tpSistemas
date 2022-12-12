package DTOS;

import java.util.List;

import entidades.Factor;
import entidades.PonderacionRtaCuestionario;
import entidades.RespuestaEnCuestionario;

public class PreguntaEnCuestionarioDTO {

	private int idPreguntaEnCuestionario;
	private Factor factor;
	private String nombre;
	private String textoPregunta;
	private String descripcion;
	private List<PonderacionRtaCuestionario> respuestas;
	private RespuestaEnCuestionario rtaSeleccionada;
	
	
	
	public PreguntaEnCuestionarioDTO() {
		super();
	}



	public PreguntaEnCuestionarioDTO(Factor factor, String nombre, String textoPregunta, String descripcion,
			List<PonderacionRtaCuestionario> respuestas, RespuestaEnCuestionario rtaSeleccionada) {
		super();
		this.factor = factor;
		this.nombre = nombre;
		this.textoPregunta = textoPregunta;
		this.descripcion = descripcion;
		this.respuestas = respuestas;
		this.rtaSeleccionada = rtaSeleccionada;
	}



	public int getIdPreguntaEnCuestionario() {
		return idPreguntaEnCuestionario;
	}



	public void setIdPreguntaEnCuestionario(int idPreguntaEnCuestionario) {
		this.idPreguntaEnCuestionario = idPreguntaEnCuestionario;
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
