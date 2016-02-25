package fr.papyfinance.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.HibernateUtil;
import fr.papyfinance.com.beans.NegociationMode;

public class NegociationModeDao {
	private SessionFactory sessionFactory;
	
	public NegociationModeDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public NegociationModeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(NegociationMode o) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
	}
	
	public NegociationMode getByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		NegociationMode o = (NegociationMode) session.createQuery("from NegociationMode where name = :cname").setParameter("cname", name).uniqueResult();
		session.getTransaction().commit();
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public List<NegociationMode> getAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<NegociationMode> negociationModes = session.createQuery("from NegociationMode").list();
		session.getTransaction().commit();
		
		return negociationModes;
	}
}
