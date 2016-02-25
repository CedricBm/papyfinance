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
import fr.papyfinance.com.beans.Publication;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.PublicationDao;
import fr.papyfinance.com.dao.UserDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PublicationTest {
	private static CompanyDao companyDao;
	private static PublicationDao publicationDao;
	private static UserDao userDao;

	@BeforeClass
    public static  void runBeforeClass() {
		Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        companyDao = new CompanyDao(sessionFactory);
        publicationDao = new PublicationDao(sessionFactory);
        userDao = new UserDao(sessionFactory);
    }
	
	@Test
	public void test1Save() {
		Company c = new Company();
		c.setName("Accenture");
		companyDao.create(c);
		
		User u = new User();
		u.setEmail("publication@example.org");
		userDao.create(u);
		
		Publication p = new Publication();
		p.setTitle("Test d'une publication");
		p.setDescription("Ceci est un test");
		p.setUser(u);
		p.setCompany(c);
		publicationDao.create(p);
		
		assertNotNull(p.getId());
	}
	
	@Test
	public void test2GetFromCompany() {
		Company c = companyDao.getByName("Accenture");
		Publication p = c.getPublications().iterator().next();
		
		assertNotNull(p);
		assertEquals(p.getTitle(), "Test d'une publication");
	}
	
	@Test
	public void test3GetFromUser() {
		User u = userDao.getByEmail("publication@example.org");
		Publication p = u.getPublications().iterator().next();
		
		assertNotNull(p);
		assertEquals(p.getTitle(), "Test d'une publication");
	}
}
