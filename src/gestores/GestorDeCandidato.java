package gestores;

import java.util.Date;
import java.util.List;
import DAOS.CandidatoDaoImp;
import entidades.Candidato;
import entidades.Cuestionario;
import interfaces.CandidatoDao;

public class GestorDeCandidato implements CandidatoDao {
	
	private static GestorDeCandidato instance;
	private static CandidatoDaoImp dao;
	
	public GestorDeCandidato() {
		super();
		// TODO Auto-generated constructor stub	
	}
	
	public static GestorDeCandidato getInstance() {
		if(instance == null) {
			instance= new GestorDeCandidato();
			dao= new CandidatoDaoImp();
		}
		return instance;
	}
	
	
	public void createCandidato(int numeroDocumento, String clave, Cuestionario cuestionario,
			String tipoDocumento, List<Cuestionario> cuestionariosTerminados, int nroCandidato, String nombre,
			String apellido, Date fechaNacimiento, String nacionalidad, String email, String escolaridad,
			Boolean eliminacion) {
		Candidato candidato = new Candidato(numeroDocumento, clave, cuestionario, tipoDocumento,
				cuestionariosTerminados, nroCandidato, nombre, apellido, fechaNacimiento, nacionalidad, email,
				escolaridad, eliminacion);
		dao.createCandidato(candidato);
	}

	@Override
	public void createCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		dao.createCandidato(candidato);
	}

	@Override
	public void updateCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		dao.updateCandidato(candidato);
	}

	@Override
	public void deleteCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		candidato.setEliminacion(true);
		dao.deleteCandidato(candidato);
	}

	@Override
	public List<Candidato> getAllCandidato() {
		// TODO Auto-generated method stub
		return dao.getAllCandidato();
	}

	@Override
	public Candidato getCandidatoById(int idCandidato) {
		// TODO Auto-generated method stub
		return dao.getCandidatoById(idCandidato);
	}

	@Override
	public Candidato getCandidatoByClave(String clave) {
		return dao.getCandidatoByClave(clave);
	}

	@Override
	public Candidato getCandidatoByNroDocumento(String tipoDocumento, int numeroDeDocumento) {
		// TODO Auto-generated method stub
		return dao.getCandidatoByNroDocumento(tipoDocumento, numeroDeDocumento);
	};
}
