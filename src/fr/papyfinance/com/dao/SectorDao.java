package fr.papyfinance.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.HibernateUtil;
import fr.papyfinance.com.beans.Sector;

public class SectorDao {
	private SessionFactory sessionFactory;
	
	public SectorDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public SectorDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(Sector s) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
	}
	
	public Sector getByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Sector s = (Sector) session.createQuery("from Sector where name = :sname").setParameter("sname", name).uniqueResult();
		session.getTransaction().commit();
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public List<Sector> getAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Sector> sectors = session.createQuery("from Sector").list();
		session.getTransaction().commit();
		
		return sectors;
	}
}