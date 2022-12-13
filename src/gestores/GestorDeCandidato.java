package gestores;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import DAOS.CandidatoDaoImp;
import DTOS.CandidatoDTO;
import DTOS.PuestoDTO;
import entidades.Bloque;
import entidades.Candidato;
import entidades.Competencia;
import entidades.Cuestionario;
import entidades.Estado;
import entidades.ItemCompetencia;
import entidades.Puesto;
import entidades.PuntajePorCompetencia;
import interfaces.CandidatoDao;

public class GestorDeCandidato {
	
	private static GestorDeCandidato instance;
	private static CandidatoDao dao;
	
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
	
	
	public void createCandidato(int numeroDocumento, Cuestionario cuestionario,
			String tipoDocumento, int nroCandidato, String nombre,
			String apellido, Date fechaNacimiento, String nacionalidad, String email, String escolaridad,
			Boolean eliminacion) {
		Candidato candidato = new Candidato(numeroDocumento, cuestionario, tipoDocumento,
				nroCandidato, nombre, apellido, fechaNacimiento, nacionalidad, email,
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
	
	public void evaluarCandidatos(List<CandidatoDTO> listaCandidatosDTO, PuestoDTO p) {
		
		//Convierto a Candidato los DTOs
		GestorDePuesto gestorPuesto = GestorDePuesto.getInstance();
		
		Puesto puesto = gestorPuesto.getPuestoByPuestoDTO(p);
		
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		
		for(CandidatoDTO candidatoDto : listaCandidatosDTO) {
			listaCandidatos.add(this.getCandidatoByDTO(candidatoDto));
		}
		
		//Creo cuestionarios
		
		GestorDeCuestionario gestorCuestionario = GestorDeCuestionario.getInstance();
		Cuestionario punteroCuestionario;
		List<Cuestionario> listaCuestionarios = new ArrayList<Cuestionario>();
		
		for(Candidato c : listaCandidatos) {
			
			//Crear clave
		    
				int len = 8;
			
		        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 
		        SecureRandom random = new SecureRandom();
		        StringBuilder sb = new StringBuilder();
		        
		        for (int i = 0; i < len; i++)
		        {
		            int randomIndex = random.nextInt(chars.length());
		            sb.append(chars.charAt(randomIndex));
		        }
		 
		        String clave = sb.toString();
		        
			//Crear Estado
		        
		        Estado estado = new Estado(new Date(), "Activo");
		        
			//Crear puntajesXCompetencia
		        
		        List<ItemCompetencia> listaItems = puesto.getCompetencias();
		        List<Competencia> competenciasDelPuesto = new ArrayList<Competencia>();
		        for(ItemCompetencia item : listaItems) {
		        	competenciasDelPuesto.add(item.getCompetencia());
		        }
		        
		        List<PuntajePorCompetencia> puntajesXCompetencia = new ArrayList<PuntajePorCompetencia>();
		        
		        for(Competencia competencia : competenciasDelPuesto) {
		        	puntajesXCompetencia.add(new PuntajePorCompetencia(0, competencia)); 
		        }
		     
		    //Creo cuestionario
			punteroCuestionario = gestorCuestionario.createCuestionario(c, clave, estado, 0, null, 
					new ArrayList<Bloque>(),
					puntajesXCompetencia, 0, null, null);
			
			//Seteo cuestionario en candidato
			c.setCuestionario(punteroCuestionario);
			
			//Aniado a lista para luego crear evaluacion
			listaCuestionarios.add(punteroCuestionario);
			
		}
		
		//Creo evaluacion
		
		GestorDeEvaluacion gestorEvaluacion = GestorDeEvaluacion.getInstance();
		
		gestorEvaluacion.createEvaluacion("Incompleta", new Date(), null, listaCuestionarios, puesto);
		
	}
	
	public Candidato getCandidatoByDTO(CandidatoDTO candidatoDto) {
		// TODO Auto-generated method stub
		return this.getCandidatoByNroDocumento(candidatoDto.getTipoDocumento(),candidatoDto.getNumeroDocumento());
	}

	public CandidatoDTO getCandidatoDTO(Candidato candidato) {

        CandidatoDTO candidatoDTO = new CandidatoDTO();
        candidatoDTO.setNumeroDocumento(candidato.getNumeroDocumento());
        if(candidato.getCuestionario()==null) {
        	candidatoDTO.setClave(null);
        }else {
        	candidatoDTO.setClave(candidato.getCuestionario().getClave());
        }
        
        candidatoDTO.setTipoDocumento(candidato.getTipoDocumento());
        candidatoDTO.setNroCandidato(candidato.getNroCandidato());
        candidatoDTO.setNombre(candidato.getNombre());
        candidatoDTO.setApellido(candidato.getApellido());
        candidatoDTO.setNacionalidad(candidato.getNacionalidad());
        candidatoDTO.setEmail(candidato.getEmail());
        candidatoDTO.setEscolaridad(candidato.getEscolaridad());
        candidatoDTO.setEliminacion(candidato.getEliminacion());

        return candidatoDTO;

    }
	
	public List<CandidatoDTO> getAllCandidatosDTO(){
		List<CandidatoDTO> candidatos = new ArrayList<CandidatoDTO>();
		for(Candidato c: this.getAllCandidato()) {
			candidatos.add(this.getCandidatoDTO(c));
		}
		
		return candidatos;
	}
	
}
	
