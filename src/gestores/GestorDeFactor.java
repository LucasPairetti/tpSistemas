package gestores;

import java.util.List;

import DAOS.FactorDaoImp;
import entidades.Factor;
import entidades.Pregunta;
import interfaces.FactorDao;


public class GestorDeFactor {
	private static GestorDeFactor instance;
	private static FactorDao dao;
	
	public GestorDeFactor() {
		super();
		// TODO Auto-generated constructor stub	
	}
	public static GestorDeFactor getInstance() {
		if(instance == null) {
			instance= new GestorDeFactor();
			dao = new FactorDaoImp();
		}
		return instance;
	}
	
	public void createFactor(String nombreFactor, int codigo, String descripcion, 
			int nroOrden, List<Pregunta> preguntas) {
		// TODO Auto-generated method stub
		Factor factor = new Factor(nombreFactor, codigo, descripcion, 
			nroOrden, preguntas);
		dao.createFactor(factor);
	}
	
	public void updateFactor(Factor factor) {
		// TODO Auto-generated method stub
		dao.updateFactor(factor);
	}
	
	public void deleteFactor(Factor factor) {
		// TODO Auto-generated method stub
		dao.deleteFactor(factor);
	}
	
	public List<Factor> getAllFactor() {
		// TODO Auto-generated method stub
		return dao.getAllFactor();
	}
	
	public Factor getFactorById(int idFactor) {
		// TODO Auto-generated method stub
		return dao.getFactorById(idFactor);
	}
	
	public Factor getFactorByCodigo(int codigoBusqueda) {
		// TODO Auto-generated method stub
		return dao.getFactorByCodigo(codigoBusqueda);
	}
	
	public Factor getFactorByNombre(int nombre) {
		// TODO Auto-generated method stub
		return dao.getFactorByNombre(nombre);
	}
}
