package interfaces;

import java.util.List;

import entidades.Competencia;
import entidades.Consultor;

public interface ConsultorDao {
	public void createConsultor(Consultor consultor);
	public void updateConsultor(Consultor consultor);
	public void deleteConsultor(Consultor consultor);
	public List<Consultor> getAllConsultor();
	public Consultor getConsultorById(int idConsultor);
	public Consultor getConsultorByContrasenia(String contrasenia);
	public Consultor getConsultorByNombre(String nombreDeUsuario);
}
