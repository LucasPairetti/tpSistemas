package gestores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import DAOS.CuestionarioDaoImp;
import DAOS.ParametrosDaoImp;
import DTOS.BloqueDTO;
import entidades.Bloque;
import entidades.Candidato;
import entidades.Competencia;
import entidades.Cuestionario;
import entidades.Estado;
import entidades.Factor;
import entidades.Pregunta;
import entidades.PreguntaEnCuestionario;
import entidades.PuntajePorCompetencia;
import interfaces.CuestionarioDao;
import interfaces.ParametrosDao;
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

	
	public Cuestionario getCuestionarioByCandidato(Candidato candidato, String clave) {
		// TODO Auto-generated method stub
		return dao.getCuestionarioByCandidato(candidato, clave);
	}
	
	public Object verificarCuestionario(int idCuestionario) {
		
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
	           
	            	return new Exception(); 
            	
    	 }
	    	 
    	 if((cuestionario.getCantidadAccesos()+1)>3) {
	    		 cuestionario.getEstado().setEstado("Incompleto");
	    	 	 cuestionario.getEstado().setFecha(new Date());
	    	  
		    	  Alert alerta= new Alert(Alert.AlertType.WARNING);
		            	alerta.setTitle("Cantidad de accesos");
		            	alerta.setContentText("Ha superado la cantidad de ingresos permitidos");
		            	alerta.showAndWait();
	    	  
		          return new Exception(); 
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
    	 	
    	 	return gestorBloque.getBloqueDTO(bloqueSiguiente);
    	 	
    	 	
    	 }
    	 
    	 if(cuestionario.getEstado().getEstado().equals("Activo")) {
    		 
    		 int milisecondsByDay = 86400000;
    		 int dias = (int) (((new Date()).getTime() - cuestionario.getFechaComienzo().getTime()) / milisecondsByDay);
    		 
	    	 if(dias > 15){
	    		 Estado estado = new Estado(new Date(), "Sin contestar");
	    		 cuestionario.setEstado(estado);
	    	   
	    	  Alert alerta= new Alert(Alert.AlertType.WARNING);
	            	alerta.setTitle("El tiempo ha expirado");
	            	alerta.setContentText("El tiempo para iniciar el cuestionario a expirado");
	            	alerta.showAndWait();
	           
	            	return new Exception(); 
	            	//Ojo
	    	 }
	    	 
	    	 return true;
	    	 
    	 }
    	 
    	 return new Exception("No esta ni en proceso ni en activo.");
	}
	
	public BloqueDTO IniciarCuestionario(int idCuestionario) {
		
		GestorDeCuestionario gestorCuestionario = GestorDeCuestionario.getInstance();		
		Cuestionario cuestionario = gestorCuestionario.getCuestionarioById(idCuestionario);
		
		GestorDePregunta gestorPregunta = GestorDePregunta.getInstance();
		
		List<Factor> factores;
		Random rand = new Random();
		
		List<Pregunta> listaPreguntas;
		List<PreguntaEnCuestionario> preguntasEnCuestionario = new ArrayList<PreguntaEnCuestionario>();
		Pregunta p;
		
		for(PuntajePorCompetencia puntaje : cuestionario.getResultadoXCompetencia()) {
			
			int sizeInicial = preguntasEnCuestionario.size();
			
			factores = puntaje.getCompetencia().getFactores();
			
			for(Factor f : factores) {
				
				listaPreguntas = f.getPreguntas();
				
				if(!(listaPreguntas.size() < 2)) {
					p = listaPreguntas.get(rand.nextInt(f.getPreguntas().size()));
					preguntasEnCuestionario.add(new PreguntaEnCuestionario(f, p));
				} 
			}
			
			if(preguntasEnCuestionario.size() <= sizeInicial) {
				//Solucionar
				//Alarma. La competencia no tiene factores con mas de 2 preguntas. No puede ser evaluado.
				return null;
			}
		}
			
			Collections.shuffle(preguntasEnCuestionario);
			
			//Creo bloques
			ParametrosDao parametros = new ParametrosDaoImp();
			int preguntasPorBloque = parametros.getPreguntasPorBloque();
			
			GestorDeBloque gestorBloque = GestorDeBloque.getInstance();
			
			int cantidadDeBloques = (int) (preguntasEnCuestionario.size()/preguntasPorBloque) + 1;
			
			Bloque bloqueX;
			
			for(int j = 0; j<cantidadDeBloques; j++) {
				
				List<PreguntaEnCuestionario> preguntasEnBloque = new ArrayList<PreguntaEnCuestionario>();
				
				int h = 0;
				
				while(h < preguntasPorBloque) {
					preguntasEnBloque.add(preguntasEnCuestionario.get(h));
					h++;
				}
				
				bloqueX = gestorBloque.createBloque(preguntasEnBloque, j+1, false);
				
				cuestionario.getBloques().add(bloqueX);
				
			}
			
			cuestionario.setFechaComienzo(new Date());
			cuestionario.setEstado(new Estado(new Date(), "Activo"));
			cuestionario.setCantidadAccesos(1);
			cuestionario.setUltimoAcceso(new Date());
			
			this.updateCuestionario(cuestionario);
			
			//EncuentroPrimerBloque
			Bloque primerBloque = gestorBloque.getBloqueById(cuestionario.getBloqueByNro(1).getIdBloque());
			
			return gestorBloque.getBloqueDTO(primerBloque);
			
		}
		
		
		
	} 
