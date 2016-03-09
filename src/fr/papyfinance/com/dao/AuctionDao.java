package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.resources.HibernateUtil;

public class AuctionDao {
  private SessionFactory sessionFactory;

  public AuctionDao() {
    sessionFactory = HibernateUtil.getSessionFactory();
  }

  public AuctionDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public boolean create(Auction o) {
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
