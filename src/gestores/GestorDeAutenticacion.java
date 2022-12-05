package gestores;

import entidades.Candidato;
import entidades.Consultor;

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
		return true;
	}

	public Boolean autenticarCandidato(String tipoDoc, int nroDoc, String clave) {
		// TODO Auto-generated method stub
		Candidato candidato = gestorCandidato.getCandidatoByNroDocumento(tipoDoc, nroDoc);
		
		if(candidato == null || !candidato.getClave().equals(clave)) {
			System.out.println("El usuario o la contraseña no son válidos"); return false;}
		else return true;
		}
		
}
