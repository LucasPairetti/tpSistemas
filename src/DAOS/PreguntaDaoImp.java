package DAOS;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import entidades.Pregunta;
import interfaces.PreguntaDao;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class PreguntaDaoImp implements PreguntaDao{

	@Override
	public void createPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.persist(pregunta);
			 System.out.println("Inserted Successfully");
			 session.getTransaction().commit();
			 session.close();
		}catch(PersistentObjectException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void updatePregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.merge(pregunta);
		System.out.println("Updated Successfully");
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deletePregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.remove(pregunta);
		//pasa a merge cuando implementemos auditorias en las entidades
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Pregunta> getAllPregunta() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Pregunta> preguntas = session
				.createQuery("SELECT a FROM Pregunta a", Pregunta.class)
				.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return preguntas;
	}

	@Override
	public List<Pregunta> getPreguntaByFactor(int idFactor) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Pregunta> criteria = builder.createQuery(Pregunta.class);
	    Root<Pregunta> from = criteria.from(Pregunta.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("idFactor"), idFactor));
	    TypedQuery<Pregunta> typed = session.createQuery(criteria);
		
	    List<Pregunta> preguntas = typed.getResultList();
	    
		session.getTransaction().commit();
		session.close();
		
		return preguntas;
		 } catch (final NoResultException nre) {
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
	}

	@Override
	public Pregunta getPreguntaById(int idPregunta) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		Pregunta pregunta = (Pregunta) session
				.get(Pregunta.class, idPregunta);
		
		session.getTransaction().commit();
		session.close();
		
		return pregunta;
		
		    } catch (final NoResultException nre) {
		    	session.getTransaction().commit();
				session.close();
		        return null;
		    }
	}

}
