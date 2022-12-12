package interfaces;

import java.util.List;

import entidades.Bloque;

public interface BloqueDao {
	public void createBloque(Bloque bloque);
	public void updateBloque(Bloque bloque);
	public void deleteBloque(Bloque bloque);
	public Bloque getBloqueById(int idBloque);
	public List<Bloque> getBloqueByCuestionario(int idCuestionario);
}
