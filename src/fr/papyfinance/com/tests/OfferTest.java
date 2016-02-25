package fr.papyfinance.com.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.UserDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfferTest {
	private static CompanyDao companyDao;
	private static OfferDao offerDao;
	private static UserDao userDao;
	
	@BeforeClass
    public static  void runBeforeClass() {
		Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        companyDao = new CompanyDao(sessionFactory);
        offerDao = new OfferDao(sessionFactory);
        userDao = new UserDao(sessionFactory);
    }

	@Test
	public void test1Save() {
		User u = new User();
		u.setEmail("offer@example.org");
		userDao.create(u);
		
		Company c = new Company();
		c.setName("IBM");
		companyDao.create(c);
		
		Offer o = new Offer();
		o.setUser(u);
		o.setCompany(c);
		offerDao.create(o);
		
		assertNotNull(o.getId());
	}
	
	@Test
	public void test2GetFromCompany() {
		Company c = companyDao.getByName("IBM");
		Offer o = c.getOffers().iterator().next();
		
		assertNotNull(o);
	}
	
	@Test
	public void test3GetFromUser() {
		User u = userDao.getByEmail("offer@example.org");
		Offer o = u.getOffers().iterator().next();
		
		assertNotNull(o);
	}
	
	@Test
	public void test4ValidDefaultValue() {
		Offer o = new Offer();
		offerDao.create(o);
		
		assertTrue(o.isValid());
	}

}
