package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.Transaction;
import fr.papyfinance.com.resources.HibernateUtil;

public class TransactionDao {
	private SessionFactory sessionFactory;
	
	public TransactionDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public TransactionDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean create(Transaction o) {
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
