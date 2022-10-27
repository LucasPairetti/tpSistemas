package gestores;

import java.util.List;

import DAOS.*;
import entidades.Competencia;
import interfaces.*;

public class GestorDeCompetencias implements CompetenciasDao {
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
	
	@Override
	public void createCompetencia(int id, int codigo, String nombre, String descripcion) {
		// TODO Auto-generated method stub
		dao.createCompetencia(id, codigo, nombre, descripcion);
	}
	@Override
	public void updateCompetencia(Competencia Competencia) {
		// TODO Auto-generated method stub
		dao.updateCompetencia(Competencia);
	}
	@Override
	public void deleteCompetencia(Competencia competencia) {
		// TODO Auto-generated method stub
		dao.deleteCompetencia(competencia);
	}
	@Override
	public List<Competencia> getAllCompetencia() {
		// TODO Auto-generated method stub
		return dao.getAllCompetencia();
		
	}
	@Override
	public Competencia getCompetenciaById(int idCompetencia) {
		// TODO Auto-generated method stub
		return dao.getCompetenciaById(idCompetencia);
	}
	@Override
	public Competencia getCompetenciaByNombre(int nombre) {
		// TODO Auto-generated method stub
		return dao.getCompetenciaByNombre(nombre);
	}
	
	
	
}
