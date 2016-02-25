package fr.papyfinance.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.HibernateUtil;
import fr.papyfinance.com.beans.OfferType;

public class OfferTypeDao {
	private SessionFactory sessionFactory;
	
	public OfferTypeDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public OfferTypeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean create(OfferType o) {
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
	
	public OfferType getByName(String name) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		OfferType o = (OfferType) session.createQuery("from OfferType where name = :sname").setParameter("sname", name).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public List<OfferType> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<OfferType> offertTypes = session.createQuery("from OfferType").list();
		session.getTransaction().commit();
		session.close();
		return offertTypes;
	}
}
