package gestores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import DAOS.CandidatoDaoImp;
import entidades.Candidato;
import entidades.Cuestionario;
import interfaces.CandidatoDao;

public class GestorDeCandidato {
	
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

	public void createCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		dao.createCandidato(candidato);
	}

	public void updateCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		dao.updateCandidato(candidato);
	}


	public void deleteCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		candidato.setEliminacion(true);
		dao.deleteCandidato(candidato);
	}


	public List<Candidato> getAllCandidato() {
		// TODO Auto-generated method stub
		return dao.getAllCandidato();
	}


	public Candidato getCandidatoById(int idCandidato) {
		// TODO Auto-generated method stub
		return dao.getCandidatoById(idCandidato);
	}

	
	public Candidato getCandidatoByClave(String clave) {
		return dao.getCandidatoByClave(clave);
	}

	
	public Candidato getCandidatoByNroDocumento(String tipoDocumento, int numeroDeDocumento) {
		// TODO Auto-generated method stub
		return dao.getCandidatoByNroDocumento(tipoDocumento, numeroDeDocumento);
	}
	
	public List<Candidato> buscarCandidatos(String apellido, String nombre, int nroCandidato) {
		List<Candidato> lista = dao.buscarCandidatos(apellido, nombre, nroCandidato);	
		/*List<CandidatoDTO> listaDTO = new ArrayList<Candidato>();
		for(Candidato candidato : lista  ) {
			listaDTO.add(this.getDTO(candidato));
		};
		return listaDTO; Descomentar cuando implementemos DTO.*/
		return lista;
	}
	
	//public Boolean validarCuestionarios(List<CandidatoDTO> listaCandidato) {
	public Boolean validarCuestionarios(List<Candidato> listaCandidato) {
		
		for(Candidato candidato : listaCandidato) {
			if(candidato.getCuestionario() != null) return false;
		};
		
		/*for(CandidatoDTO candidato : listaCandidato) {
			if(candidato.getCuestionario() != null) return false;
		};*/
		
		return true;
	}
	
}
