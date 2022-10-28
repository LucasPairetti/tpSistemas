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
	
	public void createCompetencia(int codigo, String nombre, String descripcion) {
		// TODO Auto-generated method stub
		Competencia competencia = new Competencia(codigo, nombre, descripcion);
		dao.createCompetencia(competencia);
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
	public void createCompetencia(Competencia competencia) {
		dao.createCompetencia(competencia);
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
	@Override
	public Competencia getCompetenciaByCodigo(int codigoBusqueda) {
		return dao.getCompetenciaByCodigo(codigoBusqueda);
	}
	
	
	
}
