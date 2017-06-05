package common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFaction(){
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		SessionFactory sessionFactory=configuration
				.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
	private static SessionFactory getSessionFactory(){
		if(sessionFactory==null)
			sessionFactory=buildSessionFaction();
			return sessionFactory;
	}
	 
	public static Session openSession(){
		return getSessionFactory().openSession();
	}
}
