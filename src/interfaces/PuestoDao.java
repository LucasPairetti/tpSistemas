package interfaces;

import java.util.List;

import entidades.*;

public interface PuestoDao {
	public void createPuesto(int id, int codigo, String nombre, String empresa, String descripcion, List<ItemCompetencia> competencias);
	public void updatePuesto(Puesto puesto);
	public void deletePuesto(Puesto puesto);
	public void getAllPuestos();
	public void getPuestoById(int idPuesto);
	public void getPuestoByNombre(int nombre);

}
