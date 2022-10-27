package interfaces;

import java.util.ArrayList;
import entidades.*;

public interface PuestoDao {
	public void createPuesto(Puesto puesto);
	public void updatePuesto(Puesto puesto);
	public void deletePuesto(Puesto puesto);
	public ArrayList<Puesto> getAllPuestos();
	public Puesto getPuestoById(int idPuesto);
	public Puesto getPuestoByNombre(int nombre);

}
