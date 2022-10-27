package interfaces;


import java.util.List;

import entidades.Competencia;

public interface CompetenciasDao {
	public void createCompetencia(int id, int codigo, String nombre, String descripcion);
	public void updateCompetencia(Competencia Competencia);
	public void deleteCompetencia(Competencia competencia);
	public List<Competencia> getAllCompetencia();
	public Competencia getCompetenciaById(int idCompetencia);
	public Competencia getCompetenciaByNombre(int nombre);
}
