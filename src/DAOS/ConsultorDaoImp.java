package DAOS;

import java.util.List;
import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import entidades.Consultor;
import interfaces.ConsultorDao;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

public class ConsultorDaoImp implements ConsultorDao {

	@Override
	public void updateConsultor(Consultor consultor) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.merge(consultor);
		 System.out.println("Updated Successfully");
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteConsultor(Consultor consultor) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.remove(consultor);
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Consultor> getAllConsultor() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Consultor> consultores = session
				.createQuery("SELECT a FROM Consultor", Consultor.class)
				.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return consultores;
	}

	@Override
	public Consultor getConsultorById(int idConsultor) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		Consultor consultor = (Consultor) session.get(Consultor.class, idConsultor);
		
		session.getTransaction().commit();
		session.close();
		
		return consultor;
		
		    } catch (final NoResultException nre) {
		    	session.getTransaction().commit();
				session.close();
		        return null;
		    }

	}

	@Override
	public Consultor getConsultorByContrasenia(String contrasenia) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Consultor> criteria = builder.createQuery(Consultor.class);
	    Root<Consultor> from = criteria.from(Consultor.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("contrasenia"), contrasenia));
	    TypedQuery<Consultor> typed = session.createQuery(criteria);
		
	    Consultor consultor = typed.getSingleResult();
	    
		session.getTransaction().commit();
		session.close();
		
		return consultor;
		 } catch (final NoResultException nre) {
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
	}

	@Override
	public Consultor getConsultorByNombre(String nombreDeUsuario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Consultor> criteria = builder.createQuery(Consultor.class);
	    Root<Consultor> from = criteria.from(Consultor.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("nombreDeUsuario"), nombreDeUsuario));
	    TypedQuery<Consultor> typed = session.createQuery(criteria);
		
	    Consultor consultor = typed.getSingleResult();
	    
		session.getTransaction().commit();
		session.close();
		
		return consultor;
		
		 } catch (final NoResultException nre) {
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
	}

	@Override
	public void createConsultor(Consultor consultor) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.persist(consultor);
			 System.out.println("Inserted Successfully");
			 session.getTransaction().commit();
			 session.close();
			}catch(PersistentObjectException e) {
				e.getStackTrace();
			}
	}

}
