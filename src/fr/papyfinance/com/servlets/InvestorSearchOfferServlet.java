package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.dao.ContractTypeDao;
import fr.papyfinance.com.dao.NegociationModeDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.dao.OfferTypeDao;
import fr.papyfinance.com.resources.Util;

@WebServlet("/investor/search/offers")
public class InvestorSearchOfferServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public InvestorSearchOfferServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      OfferDao od = new OfferDao();
      String p = Util.getInputValue(request, "price");
      String offerType = Util.getInputValue(request, "offerType");
      String negociationMode = Util.getInputValue(request, "negociationMode");
      String contractType = Util.getInputValue(request, "contractType");
      String seller = Util.getInputValue(request, "seller");
      String company = Util.getInputValue(request, "company");
      float price = 0;

      if (p != null) {
        price = Float.parseFloat(p);
      }
      if (offerType == null) {
        offerType = "";
      }
      if (negociationMode == null) {
        negociationMode = "";
      }
      if (contractType == null) {
        contractType = "";
      }
      if (seller == null) {
        seller = "";
      }
      if (company == null) {
        company = "";
      }

      ArrayList<Offer> res = (ArrayList<Offer>) od.getAllForInvestor(price, offerType, negociationMode, contractType, seller, company);

      request.setAttribute("listeRes", res);
      request.setAttribute("offerTypes", new OfferTypeDao().getAll());
      request.setAttribute("negociationModes", new NegociationModeDao().getAll());
      request.setAttribute("contractTypes", new ContractTypeDao().getAll());
    } catch (Exception e) {
      request.setAttribute("listeRes", null);
      request.setAttribute("offerTypes", new OfferTypeDao().getAll());
      request.setAttribute("negociationModes", new NegociationModeDao().getAll());
      request.setAttribute("contractTypes", new ContractTypeDao().getAll());
    } finally {
      this.getServletContext().getRequestDispatcher("/WEB-INF/investor/search-offers.jsp").forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
