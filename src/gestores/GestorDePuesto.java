package gestores;

import java.util.ArrayList;
import java.util.List;

import DAOS.*;
import DTOS.CompetenciaDTO;
import DTOS.PuestoDTO;
import entidades.Competencia;
import entidades.ItemCompetencia;
import entidades.Puesto;
import interfaces.PuestoDao;

public class GestorDePuesto implements PuestoDao{
	private static GestorDePuesto instance;
	private static PuestoDaoImp dao;
	
	public GestorDePuesto() {
		super();
		// TODO Auto-generated constructor stub	
	}
	public static GestorDePuesto getInstance() {
		if(instance == null) {
			instance= new GestorDePuesto();
			dao= new PuestoDaoImp();
		}
		
		
		return instance;
	}
	
	//metodos
	public void createPuesto(int codigo, String nombre, String empresa, String descripcion,
			List<ItemCompetencia> competencias) {
		GestorDeCompetencias gc = GestorDeCompetencias.getInstance();
		for(ItemCompetencia item: competencias) {
			if(item.getCompetencia().getClass()==CompetenciaDTO.class) {
				Competencia comp = gc.getCompetenciaByDTO(item.getCompetencia());
				System.out.println(comp);
				item.setCompetencia(comp);
			};
		};
		Puesto puesto = new Puesto(codigo, nombre, empresa, descripcion, competencias);
		dao.createPuesto(puesto);
	}
	
	@Override
	public void updatePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		dao.updatePuesto(puesto);
		
	}
	@Override
	public void deletePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		dao.deletePuesto(puesto);
		
	}
	@Override
	public List<Puesto> getAllPuestos() {
		// TODO Auto-generated method stub
		return dao.getAllPuestos();
		
	}
	@Override
	public Puesto getPuestoById(int idPuesto) {
		// TODO Auto-generated method stub
		return dao.getPuestoById(idPuesto);
		
	}
	@Override
	public Puesto getPuestoByNombre(String nombre) {
		// TODO Auto-generated method stub
		return dao.getPuestoByNombre(nombre);
	}
	
	@Override
	public void createPuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		dao.createPuesto(puesto);
	}
	
	@Override
	public Puesto getPuestoByCodigo(int codigo) {
		// TODO Auto-generated method stub
		return dao.getPuestoByCodigo(codigo);
	}
	
	public static PuestoDaoImp getDao() {
		// TODO Auto-generated method stub
		return dao;
	}
	
	public PuestoDTO getPuestoDTO(Puesto puesto) {
		GestorDeCompetencias gc = GestorDeCompetencias.getInstance();
		List<ItemCompetencia> competenciasDTO= new ArrayList<ItemCompetencia>();
		for(ItemCompetencia itemCompetencia: puesto.getCompetencias()) {
			
			CompetenciaDTO compDTO = gc.getCompetenciaDTO(itemCompetencia.getCompetencia());
			
			ItemCompetencia itemCompDTO = new ItemCompetencia(compDTO, itemCompetencia.getPonderacion());
			competenciasDTO.add(itemCompDTO);
			
		}
	
		PuestoDTO puestoDTO = new PuestoDTO(puesto.getCodigo(),puesto.getNombrePuesto(),puesto.getEmpresa(),puesto.getDescripcion(),competenciasDTO);
		
		
		return puestoDTO;
		
		
	}
	
	public List<PuestoDTO> getAllpuestosDTO(){
		
		List<Puesto> puestos= this.getAllPuestos();
		
		List<PuestoDTO> puestosDTO = new ArrayList<PuestoDTO>();
		for(Puesto puesto: puestos) {
			puestosDTO.add(getPuestoDTO(puesto));
		}
		
		
		return puestosDTO;
		
	}
	
	public Puesto getPuestoByPuestoDTO(PuestoDTO puestodto){
		
		Puesto puesto = dao.getPuestoById(puestodto.getIdPuesto());
		
		return puesto;
		
	}
	
}
