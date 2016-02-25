package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.HibernateUtil;
import fr.papyfinance.com.beans.Transaction;

public class TransactionDao {
	private SessionFactory sessionFactory;
	
	public TransactionDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public TransactionDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(Transaction o) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
	}
}
