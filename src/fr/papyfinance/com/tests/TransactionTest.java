package fr.papyfinance.com.tests;

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
import fr.papyfinance.com.beans.Transaction;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.TransactionDao;
import fr.papyfinance.com.dao.UserDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionTest {
	private static CompanyDao companyDao;
	private static OfferDao offerDao;
	private static UserDao userDao;
	private static TransactionDao transactionDao;

	@BeforeClass
    public static  void runBeforeClass() {
		Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        companyDao = new CompanyDao(sessionFactory);
        offerDao = new OfferDao(sessionFactory);
        userDao = new UserDao(sessionFactory);
        transactionDao = new TransactionDao(sessionFactory);
    }

	@Test
	public void test1Save() {
		User buyer = new User();
		buyer.setEmail("buyer@example.org");
		userDao.create(buyer);
		
		User seller = new User();
		seller.setEmail("seller@example.org");
		userDao.create(seller);
		
		Company c = new Company();
		c.setName("LVMH");
		companyDao.create(c);
		
		Offer o = new Offer();
		o.setUser(buyer);
		o.setCompany(c);
		offerDao.create(o);
		
		Transaction t = new Transaction();
		t.setBuyer(buyer);
		t.setSeller(seller);
		t.setOffer(o);
		t.setCompany(c);
		transactionDao.create(t);
		
		assertNotNull(t.getId());
	}
	
	@Test
	public void test2GetFromCompany() {
		Company c = companyDao.getByName("LVMH");
		Transaction t = c.getTransactions().iterator().next();
		
		assertNotNull(t);
	}
	
	@Test
	public void test3GetFromBuyer() {
		User u = userDao.getByEmail("buyer@example.org");
		Transaction t = u.getTransactionsBought().iterator().next();
		
		assertNotNull(t);
	}
	
	@Test
	public void test4GetFromSeller() {
		User u = userDao.getByEmail("seller@example.org");
		Transaction t = u.getTransactionsSold().iterator().next();
		
		assertNotNull(t);
	}
	
	@Test
	public void test5GetFromOffer() {
		User u = userDao.getByEmail("buyer@example.org");
		Offer o = u.getOffers().iterator().next();
		Transaction t = o.getTransactions().iterator().next();
		
		assertNotNull(t);
	}
}
