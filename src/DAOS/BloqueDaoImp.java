package DAOS;

import java.util.List;

import org.hibernate.PersistentObjectException;
import org.hibernate.Session;

import entidades.Bloque;
import interfaces.BloqueDao;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class BloqueDaoImp implements BloqueDao {

	@Override
	public void createBloque(Bloque bloque) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.persist(bloque);
			 System.out.println("Inserted Successfully");
			 session.getTransaction().commit();
			 session.close();
			}catch(PersistentObjectException e) {
				e.getStackTrace();
			}
	}

	@Override
	public void updateBloque(Bloque bloque) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.merge(bloque);
			 System.out.println("Updated Successfully");
			 session.getTransaction().commit();
			 session.close();
			}catch(PersistentObjectException e) {
				e.getStackTrace();
			}
	}

	@Override
	public void deleteBloque(Bloque bloque) {
		// TODO Auto-generated method stub
		try {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 session.remove(bloque);
			 System.out.println("Deleted Successfully");
			 session.getTransaction().commit();
			 session.close();
			}catch(PersistentObjectException e) {
				e.getStackTrace();
			}
	}

	@Override
	public Bloque getBloqueById(int idBloque) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		Bloque bloque = (Bloque) session.get(Bloque.class, idBloque);
		
		session.getTransaction().commit();
		session.close();
		
		return bloque;
		
		    } catch (final NoResultException nre) {
		    	session.getTransaction().commit();
				session.close();
		        return null;
		    }
	}

	@Override
	public List<Bloque> getBloqueByCuestionario(int idCuestionario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Bloque> criteria = builder.createQuery(Bloque.class);
	    Root<Bloque> from = criteria.from(Bloque.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("idCuestionario"), idCuestionario));
	    TypedQuery<Bloque> typed = session.createQuery(criteria);
		
	    List<Bloque> bloques = typed.getResultList();
	    
		session.getTransaction().commit();
		session.close();
		
		return bloques;
		
		 } catch (final NoResultException nre) {
			 
			 	session.getTransaction().commit();
				session.close();
				
		        return null;
		    }
	}

}
