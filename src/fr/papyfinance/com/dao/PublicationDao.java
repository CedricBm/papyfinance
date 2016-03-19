package fr.papyfinance.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.Publication;
import fr.papyfinance.com.resources.HibernateUtil;

public class PublicationDao {
  private SessionFactory sessionFactory;

  public PublicationDao() {
    sessionFactory = HibernateUtil.getSessionFactory();
  }

  public PublicationDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public boolean create(Publication o) {
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

  public boolean update(Publication o) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    try {
      session.update(o);
      session.getTransaction().commit();
    } catch (Exception e) {
      return false;
    } finally {
      session.close();
    }
    return true;
  }

  public Publication getById(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Publication o = (Publication) session.createQuery("from Publication where id = :cid").setParameter("cid", id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return o;
  }

  public void delete(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.createQuery("delete Publication where id = :cid").setParameter("cid", id).executeUpdate();
    session.getTransaction().commit();
    session.close();
  }
}
