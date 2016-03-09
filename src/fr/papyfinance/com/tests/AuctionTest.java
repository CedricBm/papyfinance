package fr.papyfinance.com.tests;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.dao.AuctionDao;
import fr.papyfinance.com.dao.AuctionOfferDao;
import fr.papyfinance.com.dao.OfferDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuctionTest {
  private static AuctionOfferDao auctionOfferDao;
  private static AuctionDao auctionDao;
  private static OfferDao offerDao;

  @BeforeClass
  public static void runBeforeClass() {
    Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
    auctionOfferDao = new AuctionOfferDao(sessionFactory);
    auctionDao = new AuctionDao(sessionFactory);
    offerDao = new OfferDao(sessionFactory);
  }

  @Test
  public void test1Save() {
    Auction a = new Auction();
    a.setDateFin(new Date());
    auctionDao.create(a);

    Offer o = new Offer();
    o.setAuction(a);
    offerDao.create(o);

    AuctionOffer ao = new AuctionOffer();
    ao.setAmount(314.25);
    ao.setAuction(a);
    auctionOfferDao.create(ao);

    assertNotNull(a.getId());
  }
}
