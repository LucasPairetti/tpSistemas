package DAOS;

import org.hibernate.*;
import org.hibernate.query.NativeQuery;
import interfaces.ParametrosDao;


public class ParametrosDaoImp implements ParametrosDao {
	
	
	@Override
	public int getPreguntasPorBloque() {
		 
		 int preguntasPorBloque;
		
		 String sql = "SELECT PreguntasPorBloque FROM Parametros";
		
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 
		 NativeQuery<Integer> query = session.createNativeQuery(sql, Integer.class);
		 preguntasPorBloque = query.getSingleResult();
		 
		 session.getTransaction().commit();
		 session.close();
		 
		 return preguntasPorBloque;
		 
	}
	
}
