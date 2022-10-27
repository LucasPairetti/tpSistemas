package DAOS;

import entidades.Puesto;
import java.util.*;
import interfaces.PuestoDao;
import org.hibernate.*;
import org.hibernate.query.Query;

/*import javax.persistence.*;
import javax.persistence.TypedQuery;
import jakarta.persistence.*;*/

public class PuestoDaoImp implements PuestoDao{

	@Override
	public void createPuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 session.persist(puesto);
		 System.out.println("Inserted Successfully");
		 session.getTransaction().commit();
		 session.close();
		 
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
	public ArrayList<Puesto> getAllPuestos() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query<Puesto> query = session.createQuery("select * from puesto", Puesto.class);
		ArrayList<Puesto> puestos = (ArrayList<Puesto>) query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return puestos;
		
	}

	@Override
	public Puesto getPuestoById(int idPuesto) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Puesto puesto = (Puesto) session.get(Puesto.class, idPuesto);
		
		session.getTransaction().commit();
		session.close();
		
		return puesto;
	}

	@Override
	public Puesto getPuestoByNombre(int nombre) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query<Puesto> query = session.createQuery("select * from puesto where nombrePuesto =: nombre ", Puesto.class)
	            .setParameter("nombre", nombre);
		Puesto puesto = (Puesto) query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();
		
		return puesto;
		
		
	}
	
	}
