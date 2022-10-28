package interfaces;


import java.util.List;

import entidades.Competencia;

public interface CompetenciasDao {
	public void createCompetencia(Competencia competencia);
	public void updateCompetencia(Competencia Competencia);
	public void deleteCompetencia(Competencia competencia);
	public List<Competencia> getAllCompetencia();
	public Competencia getCompetenciaById(int idCompetencia);
	public Competencia getCompetenciaByCodigo(int codigoBusqueda);
	public Competencia getCompetenciaByNombre(int nombre);
}
