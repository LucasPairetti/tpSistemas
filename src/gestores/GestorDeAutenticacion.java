package gestores;

import entidades.Candidato;
import entidades.Consultor;
import entidades.Cuestionario;

public class GestorDeAutenticacion {
	private static GestorDeAutenticacion instance;
	private static GestorDeConsultor gestorConsultor;
	private static GestorDeCandidato gestorCandidato;
	
	public GestorDeAutenticacion() {
		super();
		// TODO Auto-generated constructor stub	
	}
	
	public static GestorDeAutenticacion getInstance() {
		if(instance == null) {
			instance = new GestorDeAutenticacion();
			gestorConsultor = GestorDeConsultor.getInstance();
			gestorCandidato = GestorDeCandidato.getInstance();
			//ACTUALIZAR DIAGRAMA DE SECUENCIA. EN EL MISMO TODO LO HACE EL DE AUTENTICACION,PERO ES
			//MAS CLEAN ASI
		}
		return instance;
	}

	public boolean autenticarConsultor(String nombreDeUsuario, String contrasenia) {
		
		Consultor usuarioValidado = gestorConsultor.getConsultorByNombre(nombreDeUsuario);
    	
    	if(usuarioValidado == null) {
    		System.out.println("El usuario o la contraseña no son válidos");
    		return false; 
    		} 
    	else {
    		if(!(usuarioValidado.getConstrasenia().equals(contrasenia))) {
    		System.out.println("El usuario o la contraseña no son válidos");
    		return false;
    			}
    		}
    	
    	Consultor.setInstance(usuarioValidado);
    	
		return true;
	}

	public Boolean autenticarCandidato(String tipoDoc, int nroDoc, String clave) {
		// TODO Auto-generated method stub
		Candidato candidato = gestorCandidato.getCandidatoByNroDocumento(tipoDoc, nroDoc);
		
		if(candidato == null || !candidato.getClave().equals(clave))  {System.out.println("Los datos ingresados no son válidos o no existe un cuestionario para el Candidato"); return false;}
		
		//Falta alerta
		
		//Chequeo cuestionario
		GestorDeCuestionario gestorCuestionario = GestorDeCuestionario.getInstance();
		
		Cuestionario cuestionario = gestorCuestionario.getCuestionarioByCandidato(candidato, clave);
		///////////Cambiar en diagrama de secuencia
		if(cuestionario == null) return false;
		if(!cuestionario.getEstado().getEstado().equals("EnProceso") || 
				!cuestionario.getEstado().getEstado().equals("Activo")) return false; 
		
		return true;
	}
		
}
