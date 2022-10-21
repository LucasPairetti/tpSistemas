package interfaces;


import entidades.Competencia;

public interface CompetenciasDao {
	public void createCompetencia(int id, int codigo, String nombre, String descripcion);
	public void updateCompetencia(Competencia Competencia);
	public void deleteCompetencia(Competencia competencia);
	public void getAllCompetencia();
	public void getCompetenciaById(int idCompetencia);
	public void getCompetenciaByNombre(int nombre);
}
