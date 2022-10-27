package gestores;

import DAOS.PuestoDaoImp;

public class GestorDePuesto {
	private static GestorDePuesto instance;
	public static PuestoDaoImp dao;
	
	public GestorDePuesto() {
		super();
		// TODO Auto-generated constructor stub	
	}
	
	// singleton
	public static GestorDePuesto getInstance() {
		if(instance == null) {
			instance= new GestorDePuesto();
			dao= new PuestoDaoImp();
		}	
		return instance;
	}
	
	public static PuestoDaoImp getDao(){
		return dao;
	}
	
	//metodos
	
	
}
