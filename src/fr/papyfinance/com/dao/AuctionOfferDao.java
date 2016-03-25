package fr.papyfinance.com.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.resources.HibernateUtil;

@Stateless
public class AuctionOfferDao {
  private SessionFactory sessionFactory;

  public AuctionOfferDao() {
    sessionFactory = HibernateUtil.getSessionFactory();
  }

  public AuctionOfferDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public boolean create(AuctionOffer o) {
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

  public AuctionOffer getByName(String name) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    AuctionOffer o = (AuctionOffer) session.createQuery("from AuctionOffer where name = :cname").setParameter("cname", name).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return o;
  }

  @SuppressWarnings("unchecked")
  public List<AuctionOffer> getAll() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<AuctionOffer> auctionOffers = session.createQuery("from AuctionOffer").list();
    session.getTransaction().commit();
    session.close();
    return auctionOffers;
  }
}
