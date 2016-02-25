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
	
	public void create(OfferType o) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
	}
	
	public OfferType getByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		OfferType o = (OfferType) session.createQuery("from OfferType where name = :sname").setParameter("sname", name).uniqueResult();
		session.getTransaction().commit();
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public List<OfferType> getAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<OfferType> offertTypes = session.createQuery("from OfferType").list();
		session.getTransaction().commit();
		
		return offertTypes;
	}
}
