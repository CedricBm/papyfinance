package fr.papyfinance.com.dao;

import java.util.ArrayList;
import java.util.List;

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

  @SuppressWarnings("unchecked")
  public List<Transaction> getAll() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Transaction> transactions = session.createQuery("from Transaction").list();
    session.getTransaction().commit();
    session.close();
    return transactions;
  }

  @SuppressWarnings("unchecked")
  public ArrayList<Transaction> getAllWithAttribute(String attribute) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    ArrayList<Transaction> c = (ArrayList<Transaction>) session
        .createQuery("from Transaction where buyer.lname like :tattribute OR seller.lname like :tattribute OR offer.offerType.name like :tattribute OR company.name like :tattribute ")
        .setParameter("tattribute", "%" + attribute + "%").list();
    session.getTransaction().commit();
    session.close();
    return c;
  }

  @SuppressWarnings("unchecked")
  public ArrayList<Transaction> getAllForInvestor(String buyerName, String sellerName, String companyName, int idOffer) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    ArrayList<Transaction> c = null;
    if (idOffer < 0) {
      c = (ArrayList<Transaction>) session.createQuery("from Transaction where buyer.lname like :tbuyerName AND seller.lname like :tsellerName AND company.name like :tcompanyName")
          .setParameter("tbuyerName", "%" + buyerName + "%").setParameter("tsellerName", "%" + sellerName + "%").setParameter("tcompanyName", "%" + companyName + "%").list();
    } else {
      c = (ArrayList<Transaction>) session
          .createQuery("from Transaction where buyer.lname like :tbuyerName AND seller.lname like :tsellerName AND company.name like :tcompanyName AND offer.id = :tidOffer ")
          .setParameter("tbuyerName", "%" + buyerName + "%").setParameter("tsellerName", "%" + sellerName + "%").setParameter("tcompanyName", "%" + companyName + "%").setParameter("tidOffer", idOffer)
          .list();
    }
    session.getTransaction().commit();
    session.close();
    return c;
  }
}
