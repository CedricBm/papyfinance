package fr.papyfinance.com.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.AuctionDao;
import fr.papyfinance.com.dao.AuctionOfferDao;
import fr.papyfinance.com.dao.UserDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuctionOfferTest {
  private static AuctionOfferDao auctionOfferDao;
  private static AuctionDao auctionDao;
  private static UserDao userDao;

  @BeforeClass
  public static void runBeforeClass() {
    Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
    auctionOfferDao = new AuctionOfferDao(sessionFactory);
    auctionDao = new AuctionDao(sessionFactory);
    userDao = new UserDao(sessionFactory);
  }

  @Test
  public void test1Save() {
    Auction a = new Auction();
    auctionDao.create(a);

    User u = new User();
    u.setEmail("auction@example.org");
    userDao.create(u);

    AuctionOffer ao = new AuctionOffer();
    ao.setAmount(314.25);
    ao.setUser(u);
    ao.setAuction(a);
    auctionOfferDao.create(ao);

    assertNotNull(ao.getId());
  }

  @Test
  public void test2GetFromUser() {
    User u = userDao.getByEmail("auction@example.org");
    AuctionOffer ao = u.getAuctionOffers().iterator().next();

    assertNotNull(ao);
    assertTrue(ao.getAmount() == 314.25);
  }
}
