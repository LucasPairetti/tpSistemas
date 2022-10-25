package interfaces;

import java.util.ArrayList;
import java.util.List;

import entidades.*;

public interface PuestoDao {
	public void createPuesto(int id, int codigo, String nombre, String empresa, String descripcion, List<ItemCompetencia> competencias);
	public void updatePuesto(Puesto puesto);
	public void deletePuesto(Puesto puesto);
	public ArrayList<Puesto> getAllPuestos();
	public Puesto getPuestoById(int idPuesto);
	public Puesto getPuestoByNombre(int nombre);

}
