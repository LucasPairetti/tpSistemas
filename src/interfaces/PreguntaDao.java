package interfaces;

import java.util.List;

import entidades.Pregunta;

public interface PreguntaDao {
	public void createPregunta(Pregunta pregunta);
	public void updatePregunta(Pregunta pregunta);
	public void deletePregunta(Pregunta pregunta);
	public List<Pregunta> getAllPregunta();
	public List<Pregunta> getPreguntaByFactor(int idFactor);
	public Pregunta getPreguntaById(int idPregunta);
}
