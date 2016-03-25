package fr.papyfinance.com.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.Role;
import fr.papyfinance.com.resources.HibernateUtil;

@Stateless
public class RoleDao {
  private SessionFactory sessionFactory;

  public RoleDao() {
    sessionFactory = HibernateUtil.getSessionFactory();
  }

  public RoleDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public boolean create(Role o) {
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

  public Role getByName(String name) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Role o = (Role) session.createQuery("from Role where name = :sname").setParameter("sname", name).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return o;
  }

  @SuppressWarnings("unchecked")
  public List<Role> getAll() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Role> roles = session.createQuery("from Role").list();
    session.getTransaction().commit();
    session.close();
    return roles;
  }
}
