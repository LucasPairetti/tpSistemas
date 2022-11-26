package interfaces;

import java.util.List;

import entidades.Competencia;
import entidades.Consultor;

public interface ConsultorDao {
	public void createConsultor(String nombreDeUsuario, String contrasenia);
	public void createConsultor(Consultor consultor);
	public void updateConsultor(Consultor consultor);
	public void deleteConsultor(Consultor consultor);
	public List<Consultor> getAllConsultor();
	public Competencia getConsultorById(int idConsultor);
	public Competencia getConsultorByContrasenia(String contrasenia);
	public Competencia getConsultorByNombre(String nombreDeUsuario);
}
