package fr.papyfinance.com.forms;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.Transaction;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.UserDao;
import fr.papyfinance.com.resources.Util;

@Stateless
public class SetTransactionForm {
  @EJB
  private OfferDao offerDao;
  @EJB
  private UserDao userDao;
  @Inject
  private Util util;

  public Transaction setTransaction(HttpServletRequest request) {
    Transaction t = new Transaction();
    User b = util.currentUser(request.getSession());

    int id_offer = Integer.parseInt(util.getInputValue(request, "oid"));

    Offer o = offerDao.getById(id_offer);
    int id_seller = o.getUser().getId();
    User s = userDao.getById(id_seller);

    t.setBuyer(b);
    t.setBuyerFixed(b.toString());
    t.setCompanyFixed(o.getCompany().toString());

    t.setSeller(s);
    t.setSellerFixed(s.toString());
    t.setCompany(o.getCompany());

    t.setContractFixed(o.getContractType().getName());
    t.setOfferFixed(o.toString());

    t.setOffer(o);

    t.setTotalPrice(o.getPrice() * o.getQuantity());

    return t;
  }

}
