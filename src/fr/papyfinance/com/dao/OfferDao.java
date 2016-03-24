package fr.papyfinance.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.resources.HibernateUtil;

public class OfferDao {
	private SessionFactory sessionFactory;

	public OfferDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public OfferDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean create(Offer o) {
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

	@SuppressWarnings("unchecked")
	public List<Offer> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Offer> offers = session.createQuery("from Offer").list();
		session.getTransaction().commit();
		session.close();
		return offers;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Offer> getAllWithAttribute(String attribute) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String query = "from Offer where offerType.name like '%" + attribute
				+ "%' OR negociationMode.name like '%" + attribute
				+ "%' OR contractType.name like '%" + attribute
				+ "%' OR user.lname like '%" + attribute
				+ "%'OR company.name like '%" + attribute + "%'";
		ArrayList<Offer> c = (ArrayList<Offer>) session.createQuery(query)
				.list();
		session.getTransaction().commit();
		session.close();
		return c;
	}

	  public Offer getById(int id) {
		    Session session = sessionFactory.openSession();
		    session.beginTransaction();
		    Offer o = (Offer) session.createQuery("from Offer where id = :oid").setParameter("oid", id).uniqueResult();
		    session.getTransaction().commit();
		    session.close();
		    return o;
		  }
	  
	  public boolean update(Offer newOffer) {
		    Session session = sessionFactory.openSession();
		    session.beginTransaction();
		    try {
		      session.update(newOffer);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      return false;
		    } finally {
		      session.close();
		    }
		    return true;
		  }
	  

	  public void delete(int id) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.createQuery("delete Offer where id = :oid").setParameter("oid", id).executeUpdate();
	    session.getTransaction().commit();
	    session.close();
	  }
	  
	  

}
