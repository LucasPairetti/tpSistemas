package interfaces;

import java.util.List;

import entidades.Candidato;
import entidades.Cuestionario;

public interface CuestionarioDao {
	public void createCuestionario(Cuestionario cuestionario);
	public void updateCuestionario(Cuestionario cuestionario);
	public void deleteCuestionario(Cuestionario cuestionario);
	public List<Cuestionario> getAllCuestionario();
	public Cuestionario getCuestionarioById(int idCuestionario);
	public Cuestionario getCuestionarioByCandidato(Candidato candidato, String clave);
}
