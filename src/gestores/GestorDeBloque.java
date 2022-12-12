package gestores;

import java.util.List;

import DAOS.BloqueDaoImp;
import DAOS.CandidatoDaoImp;
import entidades.Bloque;
import entidades.PreguntaEnCuestionario;
import interfaces.BloqueDao;

public class GestorDeBloque {
	private static GestorDeBloque instance;
	private static BloqueDao dao;
	
	public GestorDeBloque() {
		super();
		// TODO Auto-generated constructor stub	
	}
	
	public static GestorDeBloque getInstance() {
		if(instance == null) {
			instance= new GestorDeBloque();
			dao= new BloqueDaoImp();
		}
		return instance;
	}

	
	public Bloque createBloque(List<PreguntaEnCuestionario> preguntas, int numeroBloque, 
			boolean completado) {
		// TODO Auto-generated method stub
		Bloque bloque = new Bloque(preguntas, numeroBloque, completado);
		dao.createBloque(bloque);
		return bloque;
	}

	
	public void updateBloque(Bloque bloque) {
		// TODO Auto-generated method stub
		dao.updateBloque(bloque);
	}

	
	public void deleteBloque(Bloque bloque) {
		// TODO Auto-generated method stub
		dao.deleteBloque(bloque);
	}

	
	public Bloque getBloqueById(int idBloque) {
		// TODO Auto-generated method stub
		return dao.getBloqueById(idBloque);
	}

	
	public List<Bloque> getBloqueByCuestionario(int idCuestionario) {
		// TODO Auto-generated method stub
		return dao.getBloqueByCuestionario(idCuestionario);
	}
}
