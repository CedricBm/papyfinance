package fr.papyfinance.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.AuctionOffer;
import fr.papyfinance.com.dao.AuctionOfferDao;
import fr.papyfinance.com.forms.SetBidForm;

@WebServlet("/investor/offers/bid/setAuction")
public class InvestorAuctionOfferServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private AuctionOfferDao auctionOfferDao;
  private SetBidForm setBidForm;

  public InvestorAuctionOfferServlet() {
    super();
    auctionOfferDao = new AuctionOfferDao();
    setBidForm = new SetBidForm();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AuctionOffer auctionOffer = setBidForm.setBid(request);
    if (auctionOfferDao.create(auctionOffer)) {
      request.getSession().setAttribute("subscribe", "Enchére réussie!");
      response.sendRedirect("/PapyFinance/investor/profile");
    } else {
      request.setAttribute("error", "une erreur");
      this.getServletContext().getRequestDispatcher("/WEB-INF/investor/bidOffer.jsp").forward(request, response);
    }
    doGet(request, response);
  }

}
