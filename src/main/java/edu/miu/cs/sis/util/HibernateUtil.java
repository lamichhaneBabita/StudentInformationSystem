package edu.miu.cs.sis.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	
	public static Session getSession(SessionFactory sf) {
	Session session = sf.getCurrentSession();
	if(session == null) {
		session = sf.openSession();
	}
	return session;
	}
}
