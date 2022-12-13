package DAOS;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.hibernate.Session;

import entidades.Candidato;
import entidades.Cuestionario;
import entidades.Puesto;
import interfaces.CuestionarioDao;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CuestionarioDaoImp implements CuestionarioDao {

	@Override
	public void createCuestionario(Cuestionario cuestionario) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.persist(cuestionario);
			 System.out.println("Inserted Successfully");
			 session.getTransaction().commit();
			 session.close();
			}catch(PersistentObjectException e) {
				e.getStackTrace();
			}
	}

	@Override
	public void updateCuestionario(Cuestionario cuestionario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.merge(cuestionario);
		 System.out.println("Updated Successfully");
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteCuestionario(Cuestionario cuestionario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.remove(cuestionario);
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Cuestionario> getAllCuestionario() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Cuestionario> puestos = session
				.createQuery("SELECT a FROM cuestionario", Cuestionario.class)
				.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return puestos;
	}

	@Override
	public Cuestionario getCuestionarioById(int idCuestionario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		Cuestionario cuestionario = (Cuestionario) session.get(Cuestionario.class, idCuestionario);
		
		session.getTransaction().commit();
		session.close();
		
		return cuestionario;
		
		    } catch (final NoResultException nre) {
		    	session.getTransaction().commit();
				session.close();
		        return null;
		    }

	}

	@Override
	public Cuestionario getCuestionarioByCandidato(Candidato candidato, String clave) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Cuestionario> criteria = builder.createQuery(Cuestionario.class);
	    Root<Cuestionario> from = criteria.from(Cuestionario.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("candidato"), candidato), 
	    		builder.equal(from.get("clave"), clave));
	    TypedQuery<Cuestionario> typed = session.createQuery(criteria);
		
	    Cuestionario cuestionario = typed.getSingleResult();
	    
		session.getTransaction().commit();
		session.close();
		
		return cuestionario;
		 } catch (final NoResultException nre) {
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
	}
	
}
