package interfaces;

import java.util.List;

import entidades.*;

public interface PuestoDao {
	public void createPuesto(Puesto puesto);
	public void updatePuesto(Puesto puesto);
	public void deletePuesto(Puesto puesto);
	public List<Puesto> getAllPuestos();
	public Puesto getPuestoById(int idPuesto);
	public Puesto getPuestoByCodigo(int codigo);
	public Puesto getPuestoByNombre(String nombre);

}
