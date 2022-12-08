package interfaces;

import java.util.List;
import entidades.Factor;

public interface FactorDao {
	public void createFactor(Factor factor);
	public void updateFactor(Factor factor);
	public void deleteFactor(Factor factor);
	public List<Factor> getAllFactor();
	public Factor getFactorById(int idFactor);
	public Factor getFactorByCodigo(int codigoBusqueda);
	public Factor getFactorByNombre(int nombre);
}
