package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.beans.HibernateUtil;

public class AuctionDao {
	private SessionFactory sessionFactory;
	
	public AuctionDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public AuctionDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(Auction o) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
	}
}
