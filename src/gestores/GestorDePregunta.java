package gestores;

import java.util.List;

import DAOS.PreguntaDaoImp;
import entidades.Factor;
import entidades.OpcionDeRespuesta;
import entidades.PonderacionRespuesta;
import entidades.Pregunta;
import interfaces.PreguntaDao;

public class GestorDePregunta {
	private static GestorDePregunta instance;
	private static PreguntaDao dao;
	
	public GestorDePregunta() {
		super();
		// TODO Auto-generated constructor stub	
	}
	public static GestorDePregunta getInstance() {
		if(instance == null) {
			instance= new GestorDePregunta();
			dao = new PreguntaDaoImp();
		}
		return instance;
	}
	
	public void createPregunta(Factor factor, String nombre, String textoPregunta, String descripcion,
			OpcionDeRespuesta opcionDeRespuesta, List<PonderacionRespuesta> respuestas) {
		// TODO Auto-generated method stub
		Pregunta pregunta = new Pregunta(factor, nombre, textoPregunta, descripcion,
		opcionDeRespuesta, respuestas);
		dao.createPregunta(pregunta);
	}

	
	public void updatePregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		dao.updatePregunta(pregunta);
	}

	
	public void deletePregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		dao.deletePregunta(pregunta);
	}

	
	public List<Pregunta> getAllPregunta() {
		// TODO Auto-generated method stub
		return dao.getAllPregunta();
	}

	
	public List<Pregunta> getPreguntaByFactor(int idFactor) {
		// TODO Auto-generated method stub
		return dao.getPreguntaByFactor(idFactor);
	}

	
	public Pregunta getPreguntaById(int idPregunta) {
		// TODO Auto-generated method stub
		return dao.getPreguntaById(idPregunta);
	}

}
