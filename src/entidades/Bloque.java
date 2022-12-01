package entidades;

import java.util.List;

public class Bloque {
	private int idBloque;
	private List<Pregunta> preguntas;
	private int numeroBloque;
	
	public Bloque(List<Pregunta> preguntas, int numeroBloque) {
		super();
		this.preguntas = preguntas;
		this.numeroBloque = numeroBloque;
	}

	public int getIdBloque() {
		return idBloque;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public int getNumeroBloque() {
		return numeroBloque;
	}

	public void setNumeroBloque(int numeroBloque) {
		this.numeroBloque = numeroBloque;
	}
	
	
}
