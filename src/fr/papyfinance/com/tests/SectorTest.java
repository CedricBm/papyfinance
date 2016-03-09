package fr.papyfinance.com.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

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
public class SectorTest {
  private static CompanyDao companyDao;
  private static SectorDao sectorDao;

  @BeforeClass
  public static void runBeforeClass() {
    Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
    companyDao = new CompanyDao(sessionFactory);
    sectorDao = new SectorDao(sessionFactory);
  }

  @Test
  public void test1Create() {
    Sector s = new Sector();
    s.setName("Banque");

    sectorDao.create(s);

    assertNotNull(s.getId());
  }

  @Test
  public void test2Get() {
    Sector s = sectorDao.getByName("Banque");

    assertNotNull(s);
  }

  @Test
  public void test3GetCompanies() {
    Sector s = sectorDao.getByName("Banque");
    Company c = new Company();
    c.setName("Société Générale");
    c.setSector(s);

    companyDao.create(c);

    Set<Company> companies = sectorDao.getByName("Banque").getCompanies();

    assertEquals(companies.size(), 1);
    assertEquals(companies.iterator().next().getName(), "Société Générale");
  }

  @Test
  public void test4GetAll() {
    List<Sector> sectors = sectorDao.getAll();

    assertTrue(sectors.size() > 0);
  }

  @Test
  public void test5UniqName() {
    Sector s = new Sector();
    s.setName("Banque");
    assertFalse(sectorDao.create(s));
  }
}
