package DAOS;

import java.util.ArrayList;
import java.util.List;

import entidades.ItemCompetencia;
import entidades.Puesto;
import interfaces.PuestoDao;

public class PuestoDaoImp implements PuestoDao{

	@Override
	public void createPuesto(int id, int codigo, String nombre, String empresa, String descripcion,
			List<ItemCompetencia> competencias) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Puesto> getAllPuestos() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Puesto getPuestoById(int idPuesto) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Puesto getPuestoByNombre(int nombre) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	}
