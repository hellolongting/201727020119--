package cn.edu.scau.cmi.longting.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ScauCmiHibernateSessionFactoryUtil {
	
	private static SessionFactory sessionFactory;
	//SessionFactory 单例
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}

}
