package fr.papyfinance.com.forms;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Auction;
import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.AuctionDao;
import fr.papyfinance.com.resources.Util;

@Stateless
public class SetBidForm {
  @EJB
  private AuctionDao auctionDao;
  @Inject
  private Util util;

  public AuctionOffer setBid(HttpServletRequest request) {
    AuctionOffer ao = new AuctionOffer();
    User b = util.currentUser(request.getSession());
    int id_offer = Integer.parseInt(util.getInputValue(request, "oid"));
    double mte = Double.parseDouble(util.getInputValue(request, "price"));

    Auction a = auctionDao.getById(id_offer);
    ao.setAuction(a);
    ao.setUser(b);
    ao.setAmount(mte);

    return ao;
  }

}
