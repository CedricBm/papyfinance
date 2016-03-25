package fr.papyfinance.com.servlets;

import java.io.IOException;
import java.text.ParseException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.papyfinance.com.beans.Offer;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.OfferDao;
import fr.papyfinance.com.forms.PostOfferForm;
import fr.papyfinance.com.resources.Util;

@WebServlet("/investor/postOffer")
public class InvestorPostOfferServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private CompanyDao companyDao;
  @EJB
  private PostOfferForm postOfferForm;
  @EJB
  private OfferDao offerDao;
  @Inject
  private Util util;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("companies", companyDao.getAllWithoutNone());

    this.getServletContext().getRequestDispatcher("/WEB-INF/investor/postOffer.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Offer o;
    try {
      o = postOfferForm.postOffer(request);
      if (offerDao.create(o)) {
        request.getSession().setAttribute("subscribe", "Publication réussie!");
        util.updateUser(request.getSession());
        response.sendRedirect("/PapyFinance/investor/profile");
      } else {
        request.setAttribute("error", "une erreur est survenue...");
        this.getServletContext().getRequestDispatcher("/WEB-INF/investor/postOffer.jsp").forward(request, response);
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
