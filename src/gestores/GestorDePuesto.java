package gestores;

import java.util.ArrayList;
import java.util.List;

import DAOS.*;
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
	public ArrayList<Puesto> getAllPuestos() {
		// TODO Auto-generated method stub
		return dao.getAllPuestos();
		
	}
	@Override
	public Puesto getPuestoById(int idPuesto) {
		// TODO Auto-generated method stub
		return dao.getPuestoById(idPuesto);
		
	}
	@Override
	public Puesto getPuestoByNombre(int nombre) {
		// TODO Auto-generated method stub
		return dao.getPuestoByNombre(nombre);
	}
	/*public void crearPuesto(int i, int parseInt, String text, String text2, String text3, Object object) {
		// TODO Auto-generated method stub
		Puesto puestoNuevo = new Puesto(i, parseInt, text, text2, text3, null);
		System.out.println("Idpuesto:"+i+"codigo:"+ puestoNuevo.getCodigo()+"nombre:"+puestoNuevo.getNombrePuesto()+"empresa:"+puestoNuevo.getEmpresa()+"descripcion:"+puestoNuevo.getDescripcion());			
	}*/
	@Override
	public void createPuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		dao.createPuesto(puesto);
	}
	public static PuestoDaoImp getDao() {
		// TODO Auto-generated method stub
		return dao;
	}
	
	
	
	
}
