package fr.papyfinance.com.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.ContractType;
import fr.papyfinance.com.beans.NegociationMode;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.OfferType;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.ContractTypeDao;
import fr.papyfinance.com.dao.NegociationModeDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.OfferTypeDao;
import fr.papyfinance.com.dao.UserDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfferTest {
  private static CompanyDao companyDao;
  private static OfferDao offerDao;
  private static OfferTypeDao offerTypeDao;
  private static UserDao userDao;
  private static NegociationModeDao negociationModeDao;
  private static ContractTypeDao contractTypeDao;

  @BeforeClass
  public static void runBeforeClass() {
    Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
    companyDao = new CompanyDao(sessionFactory);
    offerDao = new OfferDao(sessionFactory);
    offerTypeDao = new OfferTypeDao(sessionFactory);
    userDao = new UserDao(sessionFactory);
    contractTypeDao = new ContractTypeDao(sessionFactory);
    negociationModeDao = new NegociationModeDao(sessionFactory);
  }

  @Test
  public void test1Save() {
    User u = new User();
    u.setLname("test");
    u.setEmail("offer@example.org");
    userDao.create(u);

    Company c = new Company();
    c.setName("IBM");
    companyDao.create(c);

    NegociationMode nm = new NegociationMode();
    nm.setName("Prix Fixe");
    negociationModeDao.create(nm);

    OfferType ot = new OfferType();
    ot.setName("Achat");
    offerTypeDao.create(ot);

    ContractType ct = new ContractType();
    ct.setName("Action");
    contractTypeDao.create(ct);

    Offer o = new Offer();
    o.setContractType(ct);
    o.setOfferType(ot);
    o.setNegociationMode(nm);
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

  @Test
  public void test5GetAll() {
    ArrayList<Offer> lc = (ArrayList<Offer>) offerDao.getAll();

    assertEquals(lc.size(), 2);
  }

  @Test
  public void test6GetAllWithAttribute() {
    ArrayList<Offer> lc = (ArrayList<Offer>) offerDao.getAllWithAttribute("Action");

    assertEquals(lc.size(), 1);
  }
  
  @Test
  public void test7GetAllForInvestor() {
    ArrayList<Offer> lc = (ArrayList<Offer>) offerDao.getAllForInvestor(0,"","","Action","","");

    assertEquals(lc.size(), 1);
  }

}
