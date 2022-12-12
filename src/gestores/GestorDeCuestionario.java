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
import javafx.scene.control.Alert;

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
	
	public BloqueDTO verificarCuestionario(int idCuestionario) {
		
    	Cuestionario cuestionario = this.getCuestionarioById(idCuestionario);
    	  
    	 if(cuestionario.getEstado().getEstado()=="EnProceso"){
    		 
    		 int milisecondsByDay = 86400000;
    		 int dias = (int) (((new Date()).getTime() - cuestionario.getFechaComienzo().getTime()) / milisecondsByDay);
    		 
	    	 if(dias > 30){
	    		 Estado estado = new Estado(new Date(), "Incompleto");
	    		 cuestionario.setEstado(estado);
	    	   
	    	  Alert alerta= new Alert(Alert.AlertType.WARNING);
	            	alerta.setTitle("El tiempo ha expirado");
	            	alerta.setContentText("El tiempo del cuestionario a expirado");
	            	alerta.showAndWait();
	           
	            	return null; 
            	
    	 }
	    	 
    	 if((cuestionario.getCantidadAccesos()+1)>3) {
	    		 cuestionario.getEstado().setEstado("Incompleto");
	    	 	 cuestionario.getEstado().setFecha(new Date());
	    	  
		    	  Alert alerta= new Alert(Alert.AlertType.WARNING);
		            	alerta.setTitle("Cantidad de accesos");
		            	alerta.setContentText("A superado la cantidad de ingresos permitidos");
		            	alerta.showAndWait();
	    	  
		          return null; 
    	 }
    	  	
    	 	cuestionario.setCantidadAccesos(cuestionario.getCantidadAccesos()+1);
    	 	cuestionario.setUltimoAcceso(new Date());
    	 	Bloque bloqueSiguiente = null;
    	 	Bloque b;
    	 	for(int i = 1; i<=cuestionario.getBloques().size(); i++) {
    	 		b = cuestionario.getBloqueByNro(i);
    	 		if(!b.isCompletado()) {bloqueSiguiente = cuestionario.getBloqueByNro(i); break;}
    	 	}
    	 	//Chequear si tiene todos completados no deberia ser necesario
    	 	
    	 	GestorDeBloque gestorBloque = GestorDeBloque.getInstance();
    	 	
    	 	return dao.getBloqueDTO(bloqueSiguiente);
    	 	
    	 	
    	 }
	}
	
}
