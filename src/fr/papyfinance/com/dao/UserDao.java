package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.HibernateUtil;
import fr.papyfinance.com.beans.User;

public class UserDao {
	private SessionFactory sessionFactory;
	
	public UserDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(User o) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
	}
	
	public User getByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User o = (User) session.createQuery("from User where email = :semail").setParameter("semail", email).uniqueResult();
		session.getTransaction().commit();
		return o;
	}
}
