package DAOS;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.hibernate.Session;

import entidades.Competencia;
import entidades.Factor;
import interfaces.FactorDao;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class FactorDaoImp implements FactorDao{

	@Override
	public void createFactor(Factor factor) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.persist(factor);
			 System.out.println("Inserted Successfully");
			 session.getTransaction().commit();
			 session.close();
		}catch(PersistentObjectException e) {
			e.getStackTrace();
		}
			 
		}

	@Override
	public void updateFactor(Factor factor) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.merge(factor);
		System.out.println("Updated Successfully");
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteFactor(Factor factor) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.remove(factor);
		//pasa a merge cuando implementemos auditorias en las entidades
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Factor> getAllFactor() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Factor> factores = session
				.createQuery("SELECT a FROM Factor a", Factor.class)
				.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return factores;
	}

	@Override
	public Factor getFactorById(int idFactor) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		Factor factor = (Factor) session
				.get(Factor.class, idFactor);
		
		session.getTransaction().commit();
		session.close();
		
		return factor;
		
		    } catch (final NoResultException nre) {
		    	session.getTransaction().commit();
				session.close();
		        return null;
		    }
		
	}

	@Override
	public Factor getFactorByCodigo(int codigoBusqueda) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Factor> criteria = builder.createQuery(Factor.class);
	    Root<Factor> from = criteria.from(Factor.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("codigo"), codigoBusqueda));
	    TypedQuery<Factor> typed = session.createQuery(criteria);
		
	    Factor factor = typed.getSingleResult();
	    
		session.getTransaction().commit();
		session.close();
		
		return factor;
		 } catch (final NoResultException nre) {
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
	}

	@Override
	public Factor getFactorByNombre(int nombre) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Factor> criteria = builder.createQuery(Factor.class);
	    Root<Factor> from = criteria.from(Factor.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("nombreCompetencia"), nombre));
	    TypedQuery<Factor> typed = session.createQuery(criteria);
		
	    Factor factor = typed.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return factor;
		}catch(final NoResultException nre) {
				session.getTransaction().commit();
				session.close();
			
		        return null;
		    }
	}

}
