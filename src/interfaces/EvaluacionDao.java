package interfaces;

import java.util.List;

import entidades.Evaluacion;

public interface EvaluacionDao {
	public void createEvaluacion(Evaluacion evaluacion);
	public void updateEvaluacion(Evaluacion evaluacion);
	public void deleteEvaluacion(Evaluacion evaluacion);
	public List<Evaluacion> getAllEvaluacion();
	public Evaluacion getEvaluacionById(int idEvaluacion);
}
