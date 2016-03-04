package fr.papyfinance.com.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.Sector;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.SectorDao;
import fr.papyfinance.com.dao.UserDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyTest {
	private static CompanyDao companyDao;
	private static SectorDao sectorDao;
	private static UserDao userDao;
	private static OfferDao offerDao;
	
	@BeforeClass
    public static  void runBeforeClass() {
		Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        companyDao = new CompanyDao(sessionFactory);
        sectorDao = new SectorDao(sessionFactory);
        userDao = new UserDao(sessionFactory);
        offerDao = new OfferDao(sessionFactory);
    }

	@Test
	public void test1Save() {
		File file = new File("WebContent/img/sopra_steria.png");
        byte[] bFile = new byte[(int) file.length()];
 
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Sector s = new Sector();
        s.setName("SSII");
        sectorDao.create(s);

        Company c = new Company();
		c.setName("Sopra Steria");
		c.setWorkforce("36 000");
		c.setRevenue("1000000000");
		c.setWebsite("http://www.soprasteria.com/");
        c.setLogo(bFile);
        c.setSector(s);
        companyDao.create(c);
        
        User u = new User();
        u.setEmail("test@example.org");
        u.setCompany(c);
        userDao.create(u);
        
        Offer o = new Offer();
        o.setCompany(c);
        offerDao.create(o);
        
        assertNotNull(c.getId());
	}

	@Test
	public void test2Get() {
		Company c = companyDao.getByName("Sopra Steria");
		
		assertNotNull(c);
		
		try{
            FileOutputStream fos = new FileOutputStream("WebContent/images/img/sopra_steria_output.png");
            fos.write(c.getLogo());
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	@Test
	public void test3Update() {
		Company c = companyDao.getByName("Sopra Steria");
		c.setRevenue("2000000000");
		companyDao.update(c);
		
		c = companyDao.getByName("Sopra Steria");
		assertEquals(c.getRevenue(), "2000000000");
	}
	
	@Test
	public void test4GetSector() {
		Company c = companyDao.getByName("Sopra Steria");
		Sector s = c.getSector();
		
		assertEquals(s.getName(), "SSII");
	}
	
	@Test
	public void test5GetOffers() {
		Company c = companyDao.getByName("Sopra Steria");
		Set<Offer> offers = c.getOffers();
		
		assertEquals(offers.size(), 1);
	}
	
	@Test
	public void test6GetUsers() {
		Company c = companyDao.getByName("Sopra Steria");
		Set<User> users = c.getUsers();
		
		assertEquals(users.size(), 1);
		assertEquals(users.iterator().next().getEmail(), "test@example.org");
	}
	
	@Test
	public void test7UniqName() {
		Company c = new Company();
		c.setName("Sopra Steria");
		assertFalse(companyDao.create(c));
	}
	
	@Test
	public void test8GetById() {
		Company c = companyDao.getById(1);
		
		assertNotNull(c);
	}
	
	@Test
	public void test9GetAllNotAccredit()
	{
		ArrayList<Company> lc = companyDao.getAllCompanyNotAccredit();
		
		assertEquals(lc.size(), 1);
	}
}
