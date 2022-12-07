package gestores;

import java.util.ArrayList;
import java.util.List;

import DAOS.*;
import DTOS.CompetenciaDTO;
import entidades.Competencia;
import entidades.Factor;
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
	
	public void createCompetencia(int codigo, String nombre, String descripcion, List<Factor> factores) {
		// TODO Auto-generated method stub
		Competencia competencia = new Competencia(codigo, nombre, descripcion, factores);
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
	
	public CompetenciaDTO getCompetenciaDTO (Competencia competencia) {
		
		CompetenciaDTO competenciaDTO = new CompetenciaDTO(competencia.getCodigo(), competencia.getNombreCompetencia(), competencia.getDescripcion());
		
		return competenciaDTO;
		
	}
	
	public List<CompetenciaDTO> getAllCompetenciaDTO (){
		List<CompetenciaDTO> competenciasDTO= new ArrayList<CompetenciaDTO>();
		
		for(Competencia comp: getAllCompetencia()) {
			competenciasDTO.add(getCompetenciaDTO(comp));
			
		}
		
		
		return competenciasDTO;
	}
	public Competencia getCompetenciaByDTO(Competencia competenciaDTO) {
		// TODO Auto-generated method stub
		Competencia competencia = this.getCompetenciaByCodigo(competenciaDTO.getCodigo());
		return competencia;
	}
	
}
