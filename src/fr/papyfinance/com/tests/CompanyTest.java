package fr.papyfinance.com.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.Sector;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.SectorDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyTest {
	private static CompanyDao companyDao;
	private static SectorDao sectorDao;
	
	@BeforeClass
    public static  void runBeforeClass() {
		Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        companyDao = new CompanyDao(sessionFactory);
        sectorDao = new SectorDao(sessionFactory);
    }

	@Test
	public void test1Save() {
		File file = new File("WebContent/images/sopra_steria.png");
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
		c.setRevenue(1000000000);
		c.setWebsite("http://www.soprasteria.com/");
        c.setLogo(bFile);
        c.setSector(s);

        companyDao.create(c);
        
        assertNotNull(c.getId());
	}

	@Test
	public void test2Get() {
		Company c = companyDao.get("Sopra Steria");
		
		assertNotNull(c);
		
		try{
            FileOutputStream fos = new FileOutputStream("WebContent/images/tests/sopra_steria_output.png");
            fos.write(c.getLogo());
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	@Test
	public void test3Update() {
		Company c = companyDao.get("Sopra Steria");
		c.setRevenue(2000000000);
		companyDao.update(c);
		
		c = companyDao.get("Sopra Steria");
		assertEquals(c.getRevenue(), 2000000000);
	}
	
	@Test
	public void test4GetSector() {
		Company c = companyDao.get("Sopra Steria");
		Sector s = c.getSector();
		
		assertEquals(s.getName(), "SSII");
	}
	
	@Test
	public void test5Delete() {
		companyDao.delete(companyDao.get("Sopra Steria"));
		
		Company c = companyDao.get("Sopra Steria");
		assertNull(c);
	}
}
