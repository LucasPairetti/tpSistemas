package gestores;

import java.util.Date;
import java.util.List;

import DAOS.CuestionarioDaoImp;
import entidades.Bloque;
import entidades.Candidato;
import entidades.Cuestionario;
import entidades.Estado;
import entidades.PuntajePorCompetencia;
import interfaces.CuestionarioDao;

public class GestorDeCuestionario {

	private static GestorDeCuestionario instance;
	private static CuestionarioDao dao;
	
	public GestorDeCuestionario() {
		super();
		// TODO Auto-generated constructor stub	
	}
	
	public static GestorDeCuestionario getInstance() {
		
		if(instance == null) {
			
			instance = new GestorDeCuestionario();
			dao = new CuestionarioDaoImp();
			
		}
		
		return instance;
		
	}
	
	
	public Cuestionario createCuestionario(Candidato candidato, String clave, Estado estado, int cantidadAccesos,
			Date fechaComienzo, List<Bloque> bloques, List<PuntajePorCompetencia> resultadoXCompetencia,
			int resultadoFinal, Date fechaFinal, Date ultimoAcceso) {
		Cuestionario cuestionario= new Cuestionario(candidato, clave, estado, cantidadAccesos,
			fechaComienzo, bloques, resultadoXCompetencia,
			resultadoFinal, fechaFinal, ultimoAcceso);
		dao.createCuestionario(cuestionario);
		return cuestionario;
	}

	
	public void updateCuestionario(Cuestionario cuestionario) {
		// TODO Auto-generated method stub
		dao.updateCuestionario(cuestionario);
	}

	
	public void deleteCuestionario(Cuestionario cuestionario) {
		// TODO Auto-generated method stub
		dao.deleteCuestionario(cuestionario);
	}

	
	public List<Cuestionario> getAllCuestionario() {
		// TODO Auto-generated method stub
		return dao.getAllCuestionario();
	}

	
	public Cuestionario getCuestionarioById(int idCuestionario) {
		// TODO Auto-generated method stub
		return dao.getCuestionarioById(idCuestionario);
	}

	
	public Cuestionario getCuestionarioByCandidato(int idCandidato, String clave) {
		// TODO Auto-generated method stub
		return dao.getCuestionarioByCandidato(idCandidato, clave);
	}
	
}
