package com.dnd_api.persistence.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static void closeSession(Session currentSession) {
		try {
			currentSession.close();
			currentSession = null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void closeTransaction(Transaction currentTransaction) {
		try {
			currentTransaction.commit();
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}
	}
	
	public static Transaction setupTransaction(Session currentSession) {
		return currentSession.beginTransaction();
	}
	
	public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
	
	private static SessionFactory buildSessionFactory() {
		try {
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
			
			return sessionFactory;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
