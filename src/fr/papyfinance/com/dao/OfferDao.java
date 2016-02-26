package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.resources.HibernateUtil;

public class OfferDao {
	private SessionFactory sessionFactory;
	
	public OfferDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public OfferDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean create(Offer o) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
        	session.save(o);
        	session.getTransaction().commit();
        } catch (Exception e) {
        	return false;
        } finally {
        	session.close();
        }
        return true;
	}
}
