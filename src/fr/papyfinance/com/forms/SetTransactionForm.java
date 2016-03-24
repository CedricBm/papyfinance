package fr.papyfinance.com.forms;

import javax.servlet.http.HttpServletRequest;

import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.beans.Transaction;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.UserDao;
import fr.papyfinance.com.resources.Util;

public class SetTransactionForm {

  private OfferDao offerDao = new OfferDao();
  private UserDao userDao = new UserDao();

  public SetTransactionForm() {
    offerDao = new OfferDao();
    userDao = new UserDao();
  }

  public Transaction setTransaction(HttpServletRequest request) {
    Transaction t = new Transaction();
    User b = Util.currentUser(request.getSession());

    int id_offer = Integer.parseInt(Util.getInputValue(request, "oid"));

    Offer o = offerDao.getById(id_offer);
    int id_seller = o.getUser().getId();
    User s = userDao.getById(id_seller);

    t.setBuyer(b);
    t.setBuyerFixed(b.toString());
    t.setCompanyFixed(o.getCompany().getName());

    t.setSeller(s);
    t.setSellerFixed(s.toString());
    t.setCompany(o.getCompany());

    t.setContractFixed(o.getContractType().getName());
    t.setOfferFixed(o.getOfferType().getName());

    t.setOffer(o);

    return t;
  }

}
