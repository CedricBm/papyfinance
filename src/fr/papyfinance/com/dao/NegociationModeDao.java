package fr.papyfinance.com.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.NegociationMode;
import fr.papyfinance.com.resources.HibernateUtil;

@Stateless
public class NegociationModeDao {
  private SessionFactory sessionFactory;

  public NegociationModeDao() {
    sessionFactory = HibernateUtil.getSessionFactory();
  }

  public NegociationModeDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public boolean create(NegociationMode o) {
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

  public NegociationMode getByName(String name) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    NegociationMode o = (NegociationMode) session.createQuery("from NegociationMode where name = :cname").setParameter("cname", name).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return o;
  }

  @SuppressWarnings("unchecked")
  public List<NegociationMode> getAll() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<NegociationMode> negociationModes = session.createQuery("from NegociationMode").list();
    session.getTransaction().commit();
    session.close();
    return negociationModes;
  }

  public NegociationMode getById(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    NegociationMode n = (NegociationMode) session.createQuery("from NegociationMode where id = :cid").setParameter("cid", id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return n;
  }
}
