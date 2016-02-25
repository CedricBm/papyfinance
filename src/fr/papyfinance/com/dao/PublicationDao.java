package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.HibernateUtil;
import fr.papyfinance.com.beans.Publication;

public class PublicationDao {
	private SessionFactory sessionFactory;
	
	public PublicationDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public PublicationDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(Publication o) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
	}
}
