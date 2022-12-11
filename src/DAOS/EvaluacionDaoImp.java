package DAOS;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.hibernate.Session;

import entidades.Candidato;
import entidades.Evaluacion;
import interfaces.EvaluacionDao;
import jakarta.persistence.NoResultException;

public class EvaluacionDaoImp implements EvaluacionDao {

	@Override
	public void createEvaluacion(Evaluacion evaluacion) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.persist(evaluacion);
			 System.out.println("Inserted Successfully");
			 session.getTransaction().commit();
			 session.close();
			}catch(PersistentObjectException e) {
				e.getStackTrace();
			}
	}

	@Override
	public void updateEvaluacion(Evaluacion evaluacion) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.merge(evaluacion);
			 System.out.println("Updated Successfully");
			 session.getTransaction().commit();
			 session.close();
			}catch(PersistentObjectException e) {
				e.getStackTrace();
			}
	}

	@Override
	public void deleteEvaluacion(Evaluacion evaluacion) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.remove(evaluacion);
			 System.out.println("Deleted Successfully");
			 session.getTransaction().commit();
			 session.close();
			}catch(PersistentObjectException e) {
				e.getStackTrace();
			}
	}

	@Override
	public List<Evaluacion> getAllEvaluacion() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Evaluacion> evaluaciones = session
				.createQuery("SELECT a FROM Evaluacion", Evaluacion.class)
				.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return evaluaciones;
	}

	@Override
	public Evaluacion getEvaluacionById(int idEvaluacion) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		Evaluacion evaluacion = (Evaluacion) session.get(Evaluacion.class, idEvaluacion);
		
		session.getTransaction().commit();
		session.close();
		
		return evaluacion;
		
		    } catch (final NoResultException nre) {
		    	session.getTransaction().commit();
				session.close();
		        return null;
		    }
	}

}
