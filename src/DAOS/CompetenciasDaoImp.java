package DAOS;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.hibernate.Session;

import entidades.Competencia;
import entidades.Puesto;
import interfaces.CompetenciasDao;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CompetenciasDaoImp implements CompetenciasDao{

	@Override
	public void createCompetencia(Competencia competencia) {
		// TODO Auto-generated method stub
	try {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 session.persist(competencia);
		 System.out.println("Inserted Successfully");
		 session.getTransaction().commit();
		 session.close();
	}catch(PersistentObjectException e) {
		e.getStackTrace();
	}
		 
	}

	@Override
	public void updateCompetencia(Competencia competencia) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.merge(competencia);
		System.out.println("Updated Successfully");
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void deleteCompetencia(Competencia competencia) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.remove(competencia);
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Competencia> getAllCompetencia() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Competencia> competencias = session
				.createQuery("SELECT a FROM Competencia a", Competencia.class)
				.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return competencias;
	}

	@Override
	public Competencia getCompetenciaById(int idCompetencia) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		Competencia competencia = (Competencia) session
				.get(Competencia.class, idCompetencia);
		
		session.getTransaction().commit();
		session.close();
		
		return competencia;
		
		    } catch (final NoResultException nre) {
		    	session.getTransaction().commit();
				session.close();
		        return null;
		    }
		
	}

	@Override
	public Competencia getCompetenciaByCodigo(int codigoBusqueda) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Competencia> criteria = builder.createQuery(Competencia.class);
	    Root<Competencia> from = criteria.from(Competencia.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("codigo"), codigoBusqueda));
	    TypedQuery<Competencia> typed = session.createQuery(criteria);
		
	    Competencia competencia = typed.getSingleResult();
	    
		session.getTransaction().commit();
		session.close();
		
		return competencia;
		 } catch (final NoResultException nre) {
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
	}
	
	@Override
	public Competencia getCompetenciaByNombre(int nombre) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Competencia> criteria = builder.createQuery(Competencia.class);
	    Root<Competencia> from = criteria.from(Competencia.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("nombreCompetencia"), nombre));
	    TypedQuery<Competencia> typed = session.createQuery(criteria);
		
	    Competencia competencia = typed.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return competencia;
		}catch(final NoResultException nre) {
				session.getTransaction().commit();
				session.close();
			
		        return null;
		    }
	}
		
	}
