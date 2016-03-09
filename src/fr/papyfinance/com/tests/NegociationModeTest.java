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

import fr.papyfinance.com.beans.NegociationMode;
import fr.papyfinance.com.dao.NegociationModeDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NegociationModeTest {
  private static NegociationModeDao negociationModeDao;

  @BeforeClass
  public static void runBeforeClass() {
    Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
    negociationModeDao = new NegociationModeDao(sessionFactory);
  }

  @Test
  public void test1Create() {
    NegociationMode s = new NegociationMode();
    s.setName("Enchère");
    negociationModeDao.create(s);

    assertNotNull(s.getId());
  }

  @Test
  public void test2Get() {
    NegociationMode s = negociationModeDao.getByName("Enchère");

    assertNotNull(s);
  }

  @Test
  public void test3GetAll() {
    List<NegociationMode> negociationModes = negociationModeDao.getAll();

    assertTrue(negociationModes.size() > 0);
  }

  @Test
  public void test4UniqName() {
    NegociationMode s = new NegociationMode();
    s.setName("Enchère");
    assertFalse(negociationModeDao.create(s));
  }
}