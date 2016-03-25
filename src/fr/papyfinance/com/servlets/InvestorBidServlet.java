package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.dao.AuctionOfferDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.forms.SetBidForm;
import fr.papyfinance.com.resources.Util;

@WebServlet("investor/offers/bid")
public class InvestorBidServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private OfferDao of;
  @EJB
  private SetBidForm setBidForm;
  @EJB
  private AuctionOfferDao auctionOfferDao;
  @Inject
  private Util util;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(util.getInputValue(request, "id"));
    Offer o = of.getById(id);

    List<AuctionOffer> listAuctionOffers = o.getAuction().getAuctionOffers();
    Collections.reverse(listAuctionOffers);

    request.setAttribute("listAuctionOffers", listAuctionOffers);
    request.setAttribute("offer", o);
    request.setAttribute("minBid", listAuctionOffers.isEmpty() ? o.getPrice() * o.getQuantity() : listAuctionOffers.get(0).getAmount() + 1);

    this.getServletContext().getRequestDispatcher("/WEB-INF/investor/bidOffer.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AuctionOffer auctionOffer = setBidForm.setBid(request);
    if (auctionOfferDao.create(auctionOffer)) {
      request.getSession().setAttribute("subscribe", "Enchére réussie!");
      util.updateUser(request.getSession());
    } else {
      request.setAttribute("error", "une erreur est survenue...");
    }

    response.sendRedirect("/PapyFinance/investor/offers/bid?id=" + request.getParameter("oid"));
  }
}
