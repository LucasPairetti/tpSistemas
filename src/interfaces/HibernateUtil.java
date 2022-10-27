package interfaces;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	public static SessionFactory sessionFactory;
	
	// singleton
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			/*Configuration cfg = new Configuration();
			
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Puesto.class);
			cfg.addAnnotatedClass(Competencia.class);
			cfg.addAnnotatedClass(ItemCompetencia.class);*/
			
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure()
					.build();

			MetadataSources sources = new MetadataSources( standardRegistry );
					sources.addAnnotatedClass( entidades.Puesto.class );
					sources.addAnnotatedClass( entidades.Competencia.class );
					sources.addAnnotatedClass( entidades.ItemCompetencia.class );
				
			Metadata metadata = sources.buildMetadata();
				    
			SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
			
			sessionFactory = sessionFactoryBuilder.build();
			
		}	
		
		return sessionFactory;
	
	}
	

}
