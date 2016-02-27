package fr.papyfinance.com.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.Role;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.RoleDao;
import fr.papyfinance.com.dao.UserDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {
	private static CompanyDao companyDao;
	private static RoleDao roleDao;
	private static UserDao userDao;
	private static OfferDao offerDao;
	
	@BeforeClass
    public static  void runBeforeClass() {
		Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        companyDao = new CompanyDao(sessionFactory);
        roleDao = new RoleDao(sessionFactory);
        userDao = new UserDao(sessionFactory);
        offerDao = new OfferDao(sessionFactory);
    }

	@Test
	public void test1Save() {
		Company c = new Company();
		c.setName("BNP Paribas");
		companyDao.create(c);
		
		Role r = new Role();
		r.setName("Investisseur");
		roleDao.create(r);
		
		User u = new User();
		u.setEmail("user@example.org");
		u.setLogin("test");
		u.setCompany(c);
		u.setRole(r);
		userDao.create(u);
		
		Offer o = new Offer();
		o.setUser(u);
		o.setCompany(c);
		offerDao.create(o);
		
		assertNotNull(u.getId());
	}
	
	@Test
	public void test2GetFromRole() {
		Role r = roleDao.getByName("Investisseur");
		User u = r.getUsers().iterator().next();
		
		assertEquals(u.getEmail(), "user@example.org");
	}
	
	@Test
	public void test3GetFromCompany() {
		Company c = companyDao.getByName("BNP Paribas");
		User u = c.getUsers().iterator().next();
		
		assertEquals(u.getEmail(), "user@example.org");
	}
	
	@Test
	public void test4GetFromEmail() {
		User u = userDao.getByEmail("user@example.org");
				
		assertNotNull(u.getId());
	}
	
	@Test
	public void test5GetFromLogin() {
		User u = userDao.getByLogin("test");
		
		assertNotNull(u.getId());
	}
}
