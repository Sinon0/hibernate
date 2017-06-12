package common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Sinon
 */
public class HibernateUtils {
	private static SessionFactory sessionFactory;
	/**
	 * 创建nfiguration，利用其方法打开hibernate的配置文件，读取数据库配置信息
	 * @return
	 */
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
	
	/**
	 * 在通过getSessionFactory返回一个Session
	 * 后面使用Session时直接调用openSession就可以了
	 * @return
	 */
	public static Session openSession(){
		return getSessionFactory().openSession();
	}
}
