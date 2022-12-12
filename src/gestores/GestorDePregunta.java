package gestores;

import java.util.ArrayList;
import java.util.List;

import DAOS.PreguntaDaoImp;
import DTOS.PonderacionRespuestaDTO;
import DTOS.PreguntaDTO;
import DTOS.PreguntaEnCuestionarioDTO;
import entidades.Factor;
import entidades.OpcionDeRespuesta;
import entidades.PonderacionRespuesta;
import entidades.PonderacionRtaCuestionario;
import entidades.Pregunta;
import entidades.PreguntaEnCuestionario;
import entidades.RespuestaEnCuestionario;
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
	
	public PreguntaEnCuestionario crearPreguntaEnCuestionario(Factor factor, Pregunta pregunta) {
		
		PreguntaEnCuestionario preguntaEnCuestionario = new PreguntaEnCuestionario(factor, pregunta);
		
		return preguntaEnCuestionario;
	}
	
	public PreguntaDTO getPreguntaDTO(Pregunta pregunta) {

        PreguntaDTO preguntaDTO = new PreguntaDTO();
        preguntaDTO.setNombre(pregunta.getNombre());
        preguntaDTO.setTextoPregunta(pregunta.getTextoPregunta());
        preguntaDTO.setDescripcion(pregunta.getDescripcion());
        //preguntaDTO.setOpcionDeRespuesta(pregunta.getOpcionDeRespuesta()); deberia ser DTO

        GestorDePregunta gestorRespuesta = GestorDePregunta.getInstance();

        PonderacionRespuestaDTO pr;

        List<PonderacionRespuestaDTO> listaRtaDTO = new ArrayList<PonderacionRespuestaDTO>();

        for(PonderacionRespuesta ponderacion : pregunta.getRespuestas()) {

            pr = gestorRespuesta.getPonderacionRespuestaDTO(ponderacion);
            listaRtaDTO.add(pr);

        }
        preguntaDTO.setRespuestas(listaRtaDTO);

        return preguntaDTO;
    }
	
	private PonderacionRespuestaDTO getPonderacionRespuestaDTO(PonderacionRespuesta ponderacion) {
        // TODO Auto-generated method stub
        PonderacionRespuestaDTO ponderacionRespuestaDTO = new PonderacionRespuestaDTO();

        ponderacionRespuestaDTO.setPonderacion(ponderacion.getPonderacion());
        ponderacionRespuestaDTO.setRespuesta(ponderacion.getRespuesta()); //deberia ser DTO

        return ponderacionRespuestaDTO;
    }
	public PreguntaEnCuestionarioDTO getPreguntaEnCuestionarioDTO(PreguntaEnCuestionario pregunta) {
		// TODO Auto-generated method stub
		
		PreguntaEnCuestionarioDTO preguntaEnCuestionarioDTO = new PreguntaEnCuestionarioDTO();
		
		preguntaEnCuestionarioDTO.setDescripcion(pregunta.getDescripcion());
		preguntaEnCuestionarioDTO.setTextoPregunta(pregunta.getTextoPregunta());
		preguntaEnCuestionarioDTO.setFactor(pregunta.getFactor());
		preguntaEnCuestionarioDTO.setNombre(pregunta.getNombre());
		preguntaEnCuestionarioDTO.setRespuestas(pregunta.getRespuestas());
		preguntaEnCuestionarioDTO.setRtaSeleccionada(pregunta.getRtaSeleccionada());
		
		return preguntaEnCuestionarioDTO;
		
	}
	
}
