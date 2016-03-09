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

import fr.papyfinance.com.beans.OfferType;
import fr.papyfinance.com.dao.OfferTypeDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfferTypeTest {
  private static OfferTypeDao offerTypeDao;

  @BeforeClass
  public static void runBeforeClass() {
    Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
    offerTypeDao = new OfferTypeDao(sessionFactory);
  }

  @Test
  public void test1Create() {
    OfferType s = new OfferType();
    s.setName("Achat");
    offerTypeDao.create(s);

    assertNotNull(s.getId());
  }

  @Test
  public void test2Get() {
    OfferType s = offerTypeDao.getByName("Achat");

    assertNotNull(s);
  }

  @Test
  public void test3GetAll() {
    List<OfferType> offerTypes = offerTypeDao.getAll();

    assertTrue(offerTypes.size() > 0);
  }

  @Test
  public void test4UniqName() {
    OfferType s = new OfferType();
    s.setName("Achat");
    assertFalse(offerTypeDao.create(s));
  }
}