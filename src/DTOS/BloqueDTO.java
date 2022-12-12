package DTOS;

import java.util.List;

import entidades.PreguntaEnCuestionario;

public class BloqueDTO {

	
	private int idBloque;
	private List<PreguntaEnCuestionarioDTO> preguntas;
	private int numeroBloque;
	private boolean completado;
	
	
	
	public BloqueDTO() {
		super();
	}



	public BloqueDTO(List<PreguntaEnCuestionarioDTO> preguntas, int numeroBloque, boolean completado) {
		super();
		this.preguntas = preguntas;
		this.numeroBloque = numeroBloque;
		this.completado = completado;
	}



	public int getIdBloque() {
		return idBloque;
	}



	public void setIdBloque(int idBloque) {
		this.idBloque = idBloque;
	}



	public List<PreguntaEnCuestionarioDTO> getPreguntas() {
		return preguntas;
	}



	public void setPreguntas(List<PreguntaEnCuestionarioDTO> preguntas) {
		this.preguntas = preguntas;
	}



	public int getNumeroBloque() {
		return numeroBloque;
	}



	public void setNumeroBloque(int numeroBloque) {
		this.numeroBloque = numeroBloque;
	}



	public boolean isCompletado() {
		return completado;
	}



	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	
	
	
	
	
	
	
	
}
