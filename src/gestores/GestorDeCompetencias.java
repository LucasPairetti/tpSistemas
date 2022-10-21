package gestores;

import DAOS.*;

public class GestorDeCompetencias {
	private static GestorDeCompetencias instance;
	private static CompetenciasDaoImp dao;
	
	public GestorDeCompetencias() {
		super();
		// TODO Auto-generated constructor stub	
	}
	public static GestorDeCompetencias getInstance() {
		if(instance == null) {
			instance= new GestorDeCompetencias();
			dao= new CompetenciasDaoImp();
		}
		
		
		return instance;
	}
	
	//metodos
	
}
