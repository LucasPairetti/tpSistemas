package gestores;

import java.util.Date;
import java.util.List;
import DAOS.CandidatoDaoImp;
import DAOS.EvaluacionDaoImp;
import DTOS.EvaluacionDTO;
import entidades.Cuestionario;
import entidades.Evaluacion;
import entidades.Puesto;

public class GestorDeEvaluacion {
	private static GestorDeEvaluacion instance;
	private static EvaluacionDaoImp dao;
	
	public GestorDeEvaluacion() {
		super();
		// TODO Auto-generated constructor stub	
	}
	
	public static GestorDeEvaluacion getInstance() {
		if(instance == null) {
			instance= new GestorDeEvaluacion();
			dao= new EvaluacionDaoImp();
		}
		return instance;
	}
	
	 public void updateEvaluacion(Evaluacion evaluacion) {

	        dao.updateEvaluacion(evaluacion);

	    }

	    public void deleteEvaluacion(Evaluacion evaluacion) {

	        dao.deleteEvaluacion(evaluacion);

	    }

	    public void createEvaluacion(String estado, Date fechaInicio, Date fechaFin, 
	    		List<Cuestionario> cuestionarios, Puesto puesto) {
	    	Evaluacion evaluacion = new Evaluacion(estado, fechaInicio, fechaFin, cuestionarios, puesto);
	        dao.createEvaluacion(evaluacion);

	    }

	    public Evaluacion getEvaluacionById(int idEvaluacion) {
	        return dao.getEvaluacionById(idEvaluacion);
	    }

	    public List<Evaluacion> getAllEvaluaciones(){

	        return dao.getAllEvaluacion(); 
	    }
	    
	    public EvaluacionDTO getEvaluacionDTO(Evaluacion evaluacion) {

	        EvaluacionDTO evaluacionDTO = new EvaluacionDTO();
	        evaluacionDTO.setEstado(evaluacion.getEstado());
	        evaluacionDTO.setFechaInicio(evaluacion.getFechaInicio());
	        evaluacionDTO.setFechaFin(evaluacion.getFechaFin());
	        evaluacionDTO.setCuestionarios(evaluacion.getCuestionarios());
	        evaluacionDTO.setPuesto(evaluacion.getPuesto());

	        return evaluacionDTO;
	    }
	
}
