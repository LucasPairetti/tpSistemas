package DAOS;

import entidades.Puesto;
import java.util.*;
import interfaces.PuestoDao;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.hibernate.*;


public class PuestoDaoImp implements PuestoDao{

	@Override
	public void createPuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		
		try {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 session.persist(puesto);
		 System.out.println("Inserted Successfully");
		 session.getTransaction().commit();
		 session.close();
		}catch(PersistentObjectException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void updatePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.merge(puesto);
		 System.out.println("Updated Successfully");
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	//Este no se va a utilizar. Vamos a pasarle un puesto y una auditoria. Actualizamos el puesto
	//y lo mergeamos para mantenerlo.
	@Override
	public void deletePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.remove(puesto);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public List<Puesto> getAllPuestos() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Puesto> puestos = session
				.createQuery("SELECT a FROM Puesto a WHERE idAuditoria = -1", Puesto.class)
				.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return puestos;
		
	}

	@Override
	public Puesto getPuestoById(int idPuesto) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		Puesto puesto = (Puesto) session.get(Puesto.class, idPuesto);
		
		session.getTransaction().commit();
		session.close();
		
		return puesto;
		
		    } catch (final NoResultException nre) {
		    	session.getTransaction().commit();
				session.close();
		        return null;
		    }

	}

	@Override
	public Puesto getPuestoByCodigo(int codigoBusqueda) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Puesto> criteria = builder.createQuery(Puesto.class);
	    Root<Puesto> from = criteria.from(Puesto.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("codigo"), codigoBusqueda));
	    TypedQuery<Puesto> typed = session.createQuery(criteria);
		
	    Puesto puesto = typed.getSingleResult();
	    
		session.getTransaction().commit();
		session.close();
		
		return puesto;
		 } catch (final NoResultException nre) {
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
		
		
	}
	
	@Override
	public Puesto getPuestoByNombre(String nombre){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Puesto> criteria = builder.createQuery(Puesto.class);
	    Root<Puesto> from = criteria.from(Puesto.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("nombrePuesto"), nombre));
	    TypedQuery<Puesto> typed = session.createQuery(criteria);
		
	    Puesto puesto = typed.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return puesto;
		}catch(final NoResultException nre) {
				session.getTransaction().commit();
				session.close();
			
		        return null;
		    }
	}
	
	}
