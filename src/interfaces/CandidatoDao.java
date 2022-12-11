package interfaces;

import java.util.List;

import entidades.Candidato;

public interface CandidatoDao {
	public void createCandidato(Candidato candidato);
	public void updateCandidato(Candidato candidato);
	public void deleteCandidato(Candidato candidato);
	public List<Candidato> getAllCandidato();
	public Candidato getCandidatoById(int idCandidato);
	public Candidato getCandidatoByClave(String clave);
	public Candidato getCandidatoByNroDocumento(String tipoDocumento, int numeroDeDocumento);
	public List<Candidato> buscarCandidatos(String apellido, String nombre, int nroCandidato);
}
