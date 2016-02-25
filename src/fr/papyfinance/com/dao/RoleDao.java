package fr.papyfinance.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.HibernateUtil;
import fr.papyfinance.com.beans.Role;

public class RoleDao {
	private SessionFactory sessionFactory;
	
	public RoleDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public RoleDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(Role o) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
	}
	
	public Role getByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Role o = (Role) session.createQuery("from Role where name = :sname").setParameter("sname", name).uniqueResult();
		session.getTransaction().commit();
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Role> roles = session.createQuery("from Role").list();
		session.getTransaction().commit();
		
		return roles;
	}
}
