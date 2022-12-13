package DAOS;

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
					sources.addAnnotatedClass( entidades.Consultor.class );
					sources.addAnnotatedClass( entidades.Candidato.class );
					sources.addAnnotatedClass( entidades.Bloque.class );
					sources.addAnnotatedClass( entidades.Cuestionario.class );
					sources.addAnnotatedClass( entidades.Estado.class );
					sources.addAnnotatedClass( entidades.Factor.class );
					sources.addAnnotatedClass( entidades.OpcionDeRespuesta.class );
					sources.addAnnotatedClass( entidades.PonderacionRespuesta.class );
					sources.addAnnotatedClass( entidades.PonderacionRtaCuestionario.class );
					sources.addAnnotatedClass( entidades.Pregunta.class );
					sources.addAnnotatedClass( entidades.PreguntaEnCuestionario.class );
					sources.addAnnotatedClass( entidades.PuntajePorCompetencia.class );
					sources.addAnnotatedClass( entidades.Respuesta.class );
					sources.addAnnotatedClass( entidades.RespuestaEnCuestionario.class );
					sources.addAnnotatedClass( entidades.Auditoria.class );
					sources.addAnnotatedClass( entidades.Evaluacion.class );
				
			Metadata metadata = sources.buildMetadata();
				    
			SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
			
			sessionFactory = sessionFactoryBuilder.build();
			
		}	
		
		return sessionFactory;
	
	}
	

}
