package gestores;

import DAOS.PuestoDaoImp;
import entidades.Consultor;
import interfaces.CandidatoDao;
import interfaces.ConsultorDao;
import interfaces.PuestoDao;

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
    	
    	if(usuarioValidado == null || !(usuarioValidado.getNombreDeUsuario().equals(nombreDeUsuario))) {
    		System.out.println("El nombre de usuario ingresado no pertenece a un consultor registrado.");
    		return false; 
    		} 
    	else {
    		if(!(usuarioValidado.getConstrasenia().equals(contrasenia))) {
    		System.out.println("La contraseña ingresada no es correcta.");
    		return false;
    			}
    		}
		return true;
	}
}
