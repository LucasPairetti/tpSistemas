package gestores;

import java.util.ArrayList;
import java.util.List;
import DAOS.CompetenciasDaoImp;
import DAOS.ConsultorDaoImp;
import DTOS.CompetenciaDTO;
import entidades.Competencia;
import entidades.Consultor;
import interfaces.ConsultorDao;

public class GestorDeConsultor implements ConsultorDao {
	private static GestorDeConsultor instance;
	private static ConsultorDaoImp dao;
	//private Consultor instanciaDeConsultor;
	
	public GestorDeConsultor() {
		super();
		// TODO Auto-generated constructor stub	
	}
	public static GestorDeConsultor getInstance() {
		if(instance == null) {
			instance= new GestorDeConsultor();
			dao= new ConsultorDaoImp();
		}
		return instance;
	}
	
	public void createConsultor(String nombreDeUsuario, String contrasenia) {
		// TODO Auto-generated method stub
		Consultor consultor = new Consultor(nombreDeUsuario, contrasenia);
		dao.createConsultor(consultor);
	}
	@Override
	public void updateConsultor(Consultor consultor) {
		// TODO Auto-generated method stub
		dao.updateConsultor(consultor);
	}
	@Override
	public void deleteConsultor(Consultor consultor) {
		// TODO Auto-generated method stub
		dao.deleteConsultor(consultor);
	}
	@Override
	public List<Consultor> getAllConsultor() {
		// TODO Auto-generated method stub
		return dao.getAllConsultor();
	}
	@Override
	public Consultor getConsultorById(int idConsultor) {
		// TODO Auto-generated method stub
		return dao.getConsultorById(idConsultor);
	}
	@Override
	public Consultor getConsultorByContrasenia(String contrasenia) {
		// TODO Auto-generated method stub
		return dao.getConsultorByContrasenia(contrasenia);
	}
	@Override
	public Consultor getConsultorByNombre(String nombreDeUsuario) {
		// TODO Auto-generated method stub
		return dao.getConsultorByNombre(nombreDeUsuario);
	}
	@Override
	public void createConsultor(Consultor consultor) {
		// TODO Auto-generated method stub
		dao.createConsultor(consultor);
	}
	
	
}
