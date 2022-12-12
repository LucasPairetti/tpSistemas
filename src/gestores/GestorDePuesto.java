package gestores;

import java.util.ArrayList;
import java.util.List;

import DAOS.*;
import DTOS.CompetenciaDTO;
import DTOS.PuestoDTO;
import entidades.Competencia;
import entidades.Factor;
import entidades.ItemCompetencia;
import entidades.Puesto;
import interfaces.PuestoDao;

public class GestorDePuesto implements PuestoDao{
	private static GestorDePuesto instance;
	private static PuestoDao dao;
	
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
			item.setCompetencia(gc.getCompetenciaByDTO(item.getCompetencia()));
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
	
	
	public PuestoDTO getPuestoDTO(Puesto puesto) {
		GestorDeCompetencias gc = GestorDeCompetencias.getInstance();
		List<ItemCompetencia> competenciasDTO= new ArrayList<ItemCompetencia>();
		for(ItemCompetencia itemCompetencia: puesto.getCompetencias()) {
			
			CompetenciaDTO compDTO = gc.getCompetenciaDTO(itemCompetencia.getCompetencia());
			
			ItemCompetencia itemCompDTO = new ItemCompetencia(compDTO, itemCompetencia.getPonderacion());
			competenciasDTO.add(itemCompDTO);
			
		}
	
		PuestoDTO puestoDTO = new PuestoDTO(puesto.getCodigo(),puesto.getNombrePuesto(),puesto.getEmpresa(),puesto.getDescripcion(),competenciasDTO,puesto.getAuditoria());
		
		
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
	
	public Boolean validarFactores(PuestoDTO p) {
		
		GestorDePuesto gestorPuesto = GestorDePuesto.getInstance();
		
		Puesto puesto = gestorPuesto.getPuestoByDTO(p);
		
		List<Factor> listaFactores = new ArrayList<Factor>();
		
		for(ItemCompetencia item : puesto.getCompetencias()) {
			listaFactores.addAll(item.getCompetencia().getFactores());
		}
		
		for(Factor factor : listaFactores) {
			if(factor.getPreguntas().size() < 2) return false; 
		}
		
		return true;
		
	}
	private Puesto getPuestoByDTO(PuestoDTO p) {
		// TODO Auto-generated method stub
		return this.getPuestoById(p.getIdPuesto());
	}
	
}
