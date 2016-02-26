package fr.papyfinance.com.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.papyfinance.com.beans.ContractType;
import fr.papyfinance.com.dao.ContractTypeDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContractTypeTest {
	private static ContractTypeDao contractTypeDao;

	@BeforeClass
    public static  void runBeforeClass() {
		Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        contractTypeDao = new ContractTypeDao(sessionFactory);
    }

	@Test
	public void test1Create() {
		ContractType s = new ContractType();
		s.setName("Titre");
		contractTypeDao.create(s);
		
		assertNotNull(s.getId());
	}
	
	@Test
	public void test2Get() {
		ContractType s = contractTypeDao.getByName("Titre");
		
		assertNotNull(s);
	}
	
	@Test
	public void test3GetAll() {
		List<ContractType> contractTypes = contractTypeDao.getAll();

		assertTrue(contractTypes.size() > 0);
	}
	
	@Test
	public void test4UniqName() {
		ContractType s = new ContractType();
		s.setName("Titre");
		assertFalse(contractTypeDao.create(s));
	}
	
	@Test
	public void test5NullReturn() {
		ContractType s = contractTypeDao.getByName("Foobar");
		assertNull(s);
	}
}