package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.resources.HibernateUtil;

public class UserDao {
	private SessionFactory sessionFactory;
	
	public UserDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean create(User o) {
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
	
	public User getByEmail(String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User o = (User) session.createQuery("from User where email = :semail").setParameter("semail", email).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return o;
	}
}
