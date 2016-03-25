package fr.papyfinance.com.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.Transaction;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.AuctionDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.TransactionDao;

@Stateless
public class AuctionSchedule {

  @EJB
  private AuctionDao ad;
  @EJB
  private TransactionDao td;
  @EJB
  private OfferDao od;

  @Schedule(hour = "*", minute = "*")
  public void checkTransactions() {
    List<Auction> auctions = ad.getValids();
    for (Auction auction : auctions) {
      Offer offer = auction.getOffer();
      if (!auction.getAuctionOffers().isEmpty()) {
        Transaction transaction = setTransaction(auction, offer);
        td.create(transaction);
      }
      offer.setValid(false);
      od.update(offer);
    }
  }

  private Transaction setTransaction(Auction auction, Offer offer) {
    Transaction t = new Transaction();
    AuctionOffer lastOffer = auction.getAuctionOffers().get(auction.getAuctionOffers().size() - 1);
    User buyer = lastOffer.getUser();

    t.setBuyer(buyer);
    t.setBuyerFixed(buyer.toString());
    t.setCompanyFixed(offer.getCompany().toString());

    t.setSeller(offer.getUser());
    t.setSellerFixed(offer.getUser().toString());
    t.setCompany(offer.getCompany());

    t.setContractFixed(offer.getContractType().getName());
    t.setOfferFixed(offer.toString());

    t.setOffer(offer);

    t.setTotalPrice((float) lastOffer.getAmount());

    return t;
  }
}
