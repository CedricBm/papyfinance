package fr.papyfinance.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.papyfinance.com.beans.ContractType;
import fr.papyfinance.com.beans.HibernateUtil;

public class ContractTypeDao {
	private SessionFactory sessionFactory;
	
	public ContractTypeDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public ContractTypeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void create(ContractType o) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
	}
	
	public ContractType getByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		ContractType o = (ContractType) session.createQuery("from ContractType where name = :cname").setParameter("cname", name).uniqueResult();
		session.getTransaction().commit();
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public List<ContractType> getAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<ContractType> contractTypes = session.createQuery("from ContractType").list();
		session.getTransaction().commit();
		
		return contractTypes;
	}
}
