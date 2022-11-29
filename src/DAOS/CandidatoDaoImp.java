package DAOS;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.hibernate.Session;

import entidades.Candidato;
import entidades.Consultor;
import interfaces.CandidatoDAO;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CandidatoDaoImp implements CandidatoDAO {

	@Override
	public void createCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.persist(candidato);
			 System.out.println("Inserted Successfully");
			 session.getTransaction().commit();
			 session.close();
			}catch(PersistentObjectException e) {
				e.getStackTrace();
			}
	}

	@Override
	public void updateCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.merge(candidato);
		 System.out.println("Updated Successfully");
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//El gestor antes de eliminar pone en true el eliminado.
		session.merge(candidato);
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Candidato> getAllCandidato() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Candidato> candidatos = session
				.createQuery("SELECT a FROM Candidato", Candidato.class)
				.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return candidatos;
	}

	@Override
	public Candidato getCandidatoById(int idCandidato) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		Candidato candidato = (Candidato) session.get(Candidato.class, idCandidato);
		
		session.getTransaction().commit();
		session.close();
		
		return candidato;
		
		    } catch (final NoResultException nre) {
		    	session.getTransaction().commit();
				session.close();
		        return null;
		    }
	}

	@Override
	public Candidato getCandidatoByClave(String clave) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Candidato> criteria = builder.createQuery(Candidato.class);
	    Root<Candidato> from = criteria.from(Candidato.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("clave"), clave));
	    TypedQuery<Candidato> typed = session.createQuery(criteria);
		
	    Candidato candidato = typed.getSingleResult();
	    
		session.getTransaction().commit();
		session.close();
		
		return candidato;
		
		 } catch (final NoResultException nre) {
			 
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
	}

	@Override
	public Candidato getCandidatoByNroDocumento(int numeroDeDocumento) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Candidato> criteria = builder.createQuery(Candidato.class);
	    Root<Candidato> from = criteria.from(Candidato.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("numeroDeDocumento"), numeroDeDocumento));
	    TypedQuery<Candidato> typed = session.createQuery(criteria);
		
	    Candidato candidato = typed.getSingleResult();
	    
		session.getTransaction().commit();
		session.close();
		
		return candidato;
		
		 } catch (final NoResultException nre) {
			 
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
	}

}
