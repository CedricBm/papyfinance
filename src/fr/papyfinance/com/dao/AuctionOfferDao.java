package fr.papyfinance.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.beans.HibernateUtil;

public class AuctionOfferDao {
	private SessionFactory sessionFactory;
	
	public AuctionOfferDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public AuctionOfferDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(AuctionOffer o) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
	}
	
	public AuctionOffer getByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		AuctionOffer o = (AuctionOffer) session.createQuery("from AuctionOffer where name = :cname").setParameter("cname", name).uniqueResult();
		session.getTransaction().commit();
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public List<AuctionOffer> getAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<AuctionOffer> auctionOffers = session.createQuery("from AuctionOffer").list();
		session.getTransaction().commit();
		
		return auctionOffers;
	}
}
