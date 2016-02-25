package fr.papyfinance.com.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.papyfinance.com.beans.Role;
import fr.papyfinance.com.dao.RoleDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleTest {
	private static RoleDao roleDao;

	@BeforeClass
    public static  void runBeforeClass() {
		Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        roleDao = new RoleDao(sessionFactory);
    }

	@Test
	public void test1Create() {
		Role s = new Role();
		s.setName("Admin");
		roleDao.create(s);
		
		assertNotNull(s.getId());
	}
	
	@Test
	public void test2Get() {
		Role s = roleDao.getByName("Admin");
		
		assertNotNull(s);
	}
	
	@Test
	public void test3GetAll() {
		List<Role> roles = roleDao.getAll();

		assertTrue(roles.size() > 0);
	}
	
	@Test
	public void test4UniqName() {
		Role s = new Role();
		s.setName("Admin");
		assertFalse(roleDao.create(s));
	}
}