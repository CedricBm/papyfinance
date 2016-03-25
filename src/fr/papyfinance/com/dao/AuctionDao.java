package fr.papyfinance.com.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.resources.HibernateUtil;

@Stateless
public class AuctionDao {
  private SessionFactory sessionFactory;
  private DateFormat df;

  public AuctionDao() {
    sessionFactory = HibernateUtil.getSessionFactory();
    df = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
  }

  public AuctionDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
    df = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
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

  public Auction getById(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Auction a = (Auction) session.createQuery("from Auction where id = :sid").setParameter("sid", id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return a;
  }

  @SuppressWarnings("unchecked")
  public List<Auction> getValids() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Auction> auctions = (ArrayList<Auction>) session.createQuery("from Auction where date_fin = :now").setParameter("now", df.format(new Date())).list();
    session.getTransaction().commit();
    session.close();
    return auctions;
  }
}
