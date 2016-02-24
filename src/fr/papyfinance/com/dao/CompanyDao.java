package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.HibernateUtil;

public class CompanyDao {
	private SessionFactory sessionFactory;
	
	public CompanyDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public CompanyDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(Company c) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
	}
	
	public void update(Company c) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
	}
	
	public Company get(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Company c = (Company) session.createQuery("from Company where id = :cid").setParameter("cid", id).uniqueResult();
		session.getTransaction().commit();
		return c;
	}
	
	public void getAll() {
		
	}
	
	public void delete(Company c) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
	}
}
